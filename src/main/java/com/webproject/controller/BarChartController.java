package com.webproject.controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webproject.entity.Loginuser;
import com.webproject.entity.Montherchartpanel;
import com.webproject.entity.Mychartpanel;
import com.webproject.myentity.CharModel;
import com.webproject.myentity.FinandetailCustomer;
import com.webproject.service.ChartPanelService;
import com.webproject.service.FinancialService;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.DateUtil;
import com.webproject.util.IDUtils;
import com.webproject.util.PageResult;
import com.webproject.util.Result;
import com.webproject.util.UploadUtil;

@Controller
@RequestMapping("/charpanel")
public class BarChartController {

	private static final String returnChartPaht = "http://www.genealogy.zzw777.com/";
	
	

	@Autowired
	private FinancialService financialService;

	@Autowired
	private ChartPanelService chartPanelService;

	@Autowired
	private HttpServletRequest request;
	
	
	
	// 统计某一个月的数据
	@RequestMapping("/belogin/list")
	@ResponseBody
	public PageResult chartList(@RequestBody Mychartpanel search, int page, int rows) {
		return chartPanelService.charList(search, page, rows);
	}
	
	// 统计某一个月的数据
	@RequestMapping("/belogin/monthChartlist")
	@ResponseBody
	public PageResult monthChartlist(@RequestBody Montherchartpanel search, int page, int rows ) {
		return chartPanelService.monthChartlist(search, page, rows);
	}
	
	
	@RequestMapping("/belogin/loadMonth")
	@ResponseBody
	public PageResult loadMonth( int page, int rows , Long userid ) {
		Montherchartpanel search = new Montherchartpanel();
		search.setUserid(userid);
		return chartPanelService.monthChartlist(search, page, rows);
	}

	
	// 统计某一个月的数据
	@RequestMapping("/belogin/updateMontherPanel/{userid}")
	@ResponseBody
	public Result updateMontherPanel( @RequestBody Montherchartpanel montherchartpanel ,
			@PathVariable Long userid) {

		try {
			String year = montherchartpanel.getYear();
			String month = montherchartpanel.getMonth();
			if (!year.contains("年")) {
				year = year + "年";
			}
			
			if (!month.contains("月")) {
				month = month + "月";
			}

			List<FinandetailCustomer> searchCharByNeay = financialService.searchCharByNeayAndMonth(userid, year , month);

			if (CheckDataUtil.checkisEmpty(searchCharByNeay)) {
				return new Result(false, "当前无数据");
			}
			
			if (CheckDataUtil.checkisEmpty(searchCharByNeay)) {
				return new Result(false, "当前无数据");
			}
			double inMonery = 0;
			double outMonery = 0;
			for (FinandetailCustomer find : searchCharByNeay) {
				if (CheckDataUtil.checkisEqual(find.getFatherid(), 1)) {
					inMonery += find.getMonery();
				} else {
					outMonery += find.getMonery();
				}
			}
			
			String loadTitle = "本月   累计收入:" + inMonery + "  累计支出 :" + outMonery
					 + "  净收入:" +(inMonery-outMonery) + "";
			DefaultCategoryDataset defaultCategoryDataset = getMontherDataSet(searchCharByNeay);
			// 创建柱状图,柱状图分水平显示和垂直显示两种
			JFreeChart chart = ChartFactory.createBarChart( year + month+"财务报表统计", 
				loadTitle	, "单位(RMB/元)",
					defaultCategoryDataset, PlotOrientation.VERTICAL, true, true, true);
			Font FONT_20 = new Font("宋体", Font.BOLD, 20);
			Font FONT_80 = new Font("黑体", Font.BOLD, 80);
			Font FONT_50 = new Font("宋体", Font.BOLD, 50);
			Font FONT_25 = new Font("黑体", Font.BOLD, 30);
			chart.setBackgroundPaint(ChartColor.WHITE);
			// 设置整个图片的标题字体
			chart.getTitle().setFont(FONT_50);
			
			chart.getLegend().setItemFont(FONT_50);
			// 得到绘图区
			CategoryPlot plot = (CategoryPlot) chart.getPlot();

			// 设置Y轴
			NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
			rangeAxis.setLabelFont(FONT_50);
			rangeAxis.setTickLabelFont(FONT_20);
			rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());// Y轴显示整数
			rangeAxis.setAutoRangeMinimumSize(400); // 最小跨度
			rangeAxis.setTickUnit(new NumberTickUnit(0.5));
			rangeAxis.setUpperMargin(0.18);// 上边距,防止最大的一个数据靠近了坐标轴。
			rangeAxis.setLowerBound(0); // 最小值显示0
			rangeAxis.setAutoRange(false); // 不自动分配Y轴数据
			rangeAxis.setTickMarkStroke(new BasicStroke(0.6f)); // 设置坐标标记大小
			rangeAxis.setTickMarkPaint(Color.BLACK); // 设置坐标标记颜色
			rangeAxis.setTickUnit(new NumberTickUnit(400));// 每10个刻度显示一个刻度值

			// 设置X轴
			CategoryAxis domainAxis = plot.getDomainAxis();
			domainAxis.setLabelFont(FONT_80); // 设置横轴字体
			domainAxis.setTickLabelFont(FONT_80);// 设置坐标轴标尺值字体
			domainAxis.setLowerMargin(0.01);// 左边距 边框距离
			domainAxis.setUpperMargin(0.06);// 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。
			//domainAxis.setMaximumCategoryLabelLines(14);
			//domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
			
			// 在柱体的上面显示数据
			BarRenderer custombarrenderer3d = new BarRenderer();
			custombarrenderer3d.setBaseItemLabelPaint(Color.BLACK);// 数据字体的颜色
			custombarrenderer3d.setMaximumBarWidth(3.0); // 设置柱子宽度custombarrenderer3d
			custombarrenderer3d.setMinimumBarLength(2.0);
			custombarrenderer3d.setItemMargin(0.05);
			custombarrenderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			custombarrenderer3d.setBaseItemLabelsVisible(true);
			custombarrenderer3d.setItemLabelFont(FONT_25);
			plot.setRenderer(custombarrenderer3d);

			// 得到绘图区的域轴(横轴),设置标签的字体
			plot.getDomainAxis().setLabelFont(FONT_50);
			// plot.get
			// 设置横轴标签项字体
			plot.getDomainAxis().setTickLabelFont(FONT_50);
			// 设置范围轴(纵轴)字体
			plot.getRangeAxis().setLabelFont(FONT_50);
			// 存储成图片
			// 设置chart的背景图片
			String backImage = SearchImageContentPath() + "monthackimage"+ month +".jpg";
			backImage = backImage.replace("月.", ".");
			File backimageFile = new File(backImage);
			if (backimageFile.exists()) {
				chart.setBackgroundImage(ImageIO.read(backimageFile));
				plot.setBackgroundImage(ImageIO.read(backimageFile));
			}
			plot.setForegroundAlpha(1.0f);
			String imageUploadName = IDUtils.getImageName();
			BufferedImage bi = chart.createBufferedImage(2400, 1200, 2400, 1200, null);
			Graphics2D g2 = (Graphics2D) bi.getGraphics();
			g2.setBackground(Color.WHITE);// 设置背景色
			// g2.clearRect(0, 0, 111, 111);//通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
			g2.setPaint(Color.BLUE);// 设置画笔,设置Paint属性
			
			// 上传到本地
			ImageIO.write(bi, "png", new File(SearchImageContentPath() +imageUploadName));
			g2.dispose();
			
			// 上传到七牛云
			UploadUtil.upload(SearchImageContentPath() +imageUploadName, imageUploadName);
			
			// 同步数据
			String returnPath = returnChartPaht + imageUploadName;
			chartPanelService.createMyMonthPanel(userid, returnPath, year,month);
			Thread.sleep(2000);
			// 删除本地文件
			File delete = new File(SearchImageContentPath() +imageUploadName);
			delete.delete();
			return new Result(true, year + month + "财务报表生成成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result(false, "操作失败,稍后从试");
	}

	public CategoryDataset getDataSet(List<FinandetailCustomer> searchCharByNeay) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<CharModel> modelList = new ArrayList<>();
		modelList.add(new CharModel("一月", "收入", 0));
		modelList.add(new CharModel("一月", "支出", 0));
		modelList.add(new CharModel("一月", "净收入", 0));

		modelList.add(new CharModel("二月", "收入", 0));
		modelList.add(new CharModel("二月", "支出", 0));
		modelList.add(new CharModel("二月", "净收入", 0));

		modelList.add(new CharModel("三月", "收入", 0));
		modelList.add(new CharModel("三月", "支出", 0));
		modelList.add(new CharModel("三月", "净收入", 0));

		modelList.add(new CharModel("四月", "收入", 0));
		modelList.add(new CharModel("四月", "支出", 0));
		modelList.add(new CharModel("四月", "净收入", 0));

		modelList.add(new CharModel("五月", "收入", 0));
		modelList.add(new CharModel("五月", "支出", 0));
		modelList.add(new CharModel("五月", "净收入", 0));

		modelList.add(new CharModel("六月", "收入", 0));
		modelList.add(new CharModel("六月", "支出", 0));
		modelList.add(new CharModel("六月", "净收入", 0));

		modelList.add(new CharModel("七月", "收入", 0));
		modelList.add(new CharModel("七月", "支出", 0));
		modelList.add(new CharModel("七月", "净收入", 0));

		modelList.add(new CharModel("八月", "收入", 0));
		modelList.add(new CharModel("八月", "支出", 0));
		modelList.add(new CharModel("八月", "净收入", 0));

		modelList.add(new CharModel("九月", "收入", 0));
		modelList.add(new CharModel("九月", "支出", 0));
		modelList.add(new CharModel("九月", "净收入", 0));

		modelList.add(new CharModel("十月", "收入", 0));
		modelList.add(new CharModel("十月", "支出", 0));
		modelList.add(new CharModel("十月", "净收入", 0));

		modelList.add(new CharModel("十一月", "收入", 0));
		modelList.add(new CharModel("十一月", "支出", 0));
		modelList.add(new CharModel("十一月", "净收入", 0));

		modelList.add(new CharModel("十二月", "收入", 0));
		modelList.add(new CharModel("十二月", "支出", 0));
		modelList.add(new CharModel("十二月", "净收入", 0));

		// 先得到一月的数据
		for (FinandetailCustomer find : searchCharByNeay) {
			String month = DateUtil.DateToMonth("yyyy-MM-dd", find.getCreatetime());
			// 这里计算收入总和
			double inMonery = 0;
			double outMonery = 0;
			if (CheckDataUtil.checkisEqual(find.getFatherid(), 1)) {
				inMonery = find.getMonery();
			} else {
				outMonery = find.getMonery();
			}
			for (CharModel charData : modelList) {
				if (charData.getMonth().equals(month) && charData.getType().equals("收入")) {
					charData.setTotal(inMonery + charData.getTotal());
				}
				if (charData.getMonth().equals(month) && charData.getType().equals("支出")) {
					charData.setTotal(outMonery + charData.getTotal());
				}
				if (charData.getMonth().equals(month) && charData.getType().equals("净收入")) {
					charData.setTotal(inMonery - outMonery + charData.getTotal());
				}

			}

		}

		for (CharModel data : modelList) {

			dataset.addValue(data.getTotal(), data.getType(), data.getMonth());
		}

		return dataset;
	}

	@RequestMapping("/belogin/updateChartPanel")
	@ResponseBody
	public Result createCharByNeay(@RequestBody Mychartpanel mychartpanel) {

		try {

			if (CheckDataUtil.checkisEmpty(mychartpanel.getUserid())) {
				return new Result(false, "登录超时,请重新登录");
			}
			Long userid = Long.valueOf(mychartpanel.getUserid());
			
			String yearString = mychartpanel.getYearstring();

			if (!yearString.contains("年")) {
				yearString = yearString + "年";
			}

			List<FinandetailCustomer> searchCharByNeay = financialService.searchCharByNeay(userid, yearString);
			if (CheckDataUtil.checkisEmpty(searchCharByNeay)) {
				return new Result(false, "当前无数据");
			}
			double inMonery = 0;
			double outMonery = 0;
			for (FinandetailCustomer find : searchCharByNeay) {
				if (CheckDataUtil.checkisEqual(find.getFatherid(), 1)) {
					inMonery += find.getMonery();
				} else {
					outMonery += find.getMonery();
				}
			}
			String loadTitle = "全年  累计收入金额:" + inMonery + " 累计支出 :" + outMonery
					+" 净收入:" + (inMonery - outMonery);
			
			DefaultCategoryDataset defaultCategoryDataset = getDefaultCategoryDataset(searchCharByNeay);
			// 创建柱状图,柱状图分水平显示和垂直显示两种
			JFreeChart chart = ChartFactory.createBarChart( yearString+"度财务报表统计", 
					loadTitle, "单位(RMB/元)",
					defaultCategoryDataset, PlotOrientation.VERTICAL, true, true, true);
			Font FONT_20 = new Font("黑体", Font.BOLD, 20);
			Font FONT_30 = new Font("宋体", Font.BOLD, 30);
			Font FONT_50 = new Font("宋体", Font.BOLD, 50);
			Font FONT_25 = new Font("黑体", Font.BOLD, 25);
			chart.setBackgroundPaint(ChartColor.WHITE);
			// 设置整个图片的标题字体
			chart.getTitle().setFont(FONT_50);
			
			chart.getLegend().setItemFont(FONT_50);
			// 得到绘图区
			CategoryPlot plot = (CategoryPlot) chart.getPlot();

			// 设置Y轴
			NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
			rangeAxis.setLabelFont(FONT_50);
			rangeAxis.setPositiveArrowVisible(false);
			rangeAxis.setTickLabelFont(FONT_50);// 设置坐标轴标尺值字体
			rangeAxis.setTickLabelFont(FONT_20);
			rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());// Y轴显示整数
			rangeAxis.setAutoRangeMinimumSize(1000); // 最小跨度
			rangeAxis.setTickUnit(new NumberTickUnit(0.5));
			rangeAxis.setUpperMargin(0.18);// 上边距,防止最大的一个数据靠近了坐标轴。
			rangeAxis.setLowerBound(0); // 最小值显示0
			rangeAxis.setAutoRange(false); // 不自动分配Y轴数据
			rangeAxis.setTickMarkStroke(new BasicStroke(0.6f)); // 设置坐标标记大小
			rangeAxis.setTickMarkPaint(Color.BLACK); // 设置坐标标记颜色
			rangeAxis.setTickUnit(new NumberTickUnit(1000));// 每10个刻度显示一个刻度值

			// 设置X轴
			CategoryAxis domainAxis = plot.getDomainAxis();
			domainAxis.setLabelFont(FONT_50); // 设置横轴字体
			domainAxis.setTickLabelFont(FONT_50);// 设置坐标轴标尺值字体
			domainAxis.setLowerMargin(0.01);// 左边距 边框距离
			domainAxis.setUpperMargin(0.06);// 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。
			domainAxis.setMaximumCategoryLabelLines(14);
			domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
			
			// 在柱体的上面显示数据
			BarRenderer custombarrenderer3d = new BarRenderer();
			custombarrenderer3d.setBaseItemLabelPaint(Color.BLACK);// 数据字体的颜色
			custombarrenderer3d.setMaximumBarWidth(5.0); // 设置柱子宽度custombarrenderer3d
			custombarrenderer3d.setMinimumBarLength(3.5);
			custombarrenderer3d.setDrawBarOutline(true); 
			custombarrenderer3d.setItemMargin(0.2);
			custombarrenderer3d.setItemLabelAnchorOffset(5);
			custombarrenderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			custombarrenderer3d.setBaseItemLabelsVisible(true);
			custombarrenderer3d.setItemLabelFont(FONT_20);
			plot.setRenderer(custombarrenderer3d);

			// 得到绘图区的域轴(横轴),设置标签的字体
			plot.getDomainAxis().setLabelFont(FONT_30);
			// plot.get
			// 设置横轴标签项字体
			plot.getDomainAxis().setTickLabelFont(FONT_20);
			// 设置范围轴(纵轴)字体
			plot.getRangeAxis().setLabelFont(FONT_50);
			
			plot.setForegroundAlpha(0.5f); 
			// 获取背景图片
			String yearImageContentPath = SearchImageContentPath() + "yearbackimg.jpg";
			File backImageFile = new File(yearImageContentPath);
			if (backImageFile.exists()) {
				chart.setBackgroundImage(ImageIO.read(backImageFile));
				plot.setBackgroundImage(ImageIO.read(backImageFile));
			}
			
			
			plot.setForegroundAlpha(1.0f);
			String uploadImageName = IDUtils.getImageName();
			BufferedImage bi = chart.createBufferedImage(2400, 1200, 2400, 1200, null);
			Graphics2D g2 = (Graphics2D) bi.getGraphics();
			g2.setBackground(Color.WHITE);// 设置背景色
			g2.setPaint(Color.BLUE);// 设置画笔,设置Paint属性
			// 吧文件写入本地服务器
			ImageIO.write(bi, "png", new File(SearchImageContentPath() +uploadImageName));
			g2.dispose();
			
			// 上传到七牛云服务器
			UploadUtil.upload(SearchImageContentPath() + uploadImageName ,uploadImageName );
			String returnPath = returnChartPaht + uploadImageName;
			chartPanelService.createMyChartPanel(userid, returnPath, yearString);
			Thread.sleep(1000);
			File delete = new File(SearchImageContentPath() +uploadImageName);
			delete.delete();
			return new Result(true, yearString + "财务报表生成成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result(false, "操作失败,稍后从试");
	}

	public ChartPanel createCharPanel(List<FinandetailCustomer> searchCharByNeay, String yearString) {
		CategoryDataset dataset = getDataSet(searchCharByNeay);
		JFreeChart chart = ChartFactory.createBarChart3D(yearString + "度财务报表统计", // 图表标题
				"水果种类", // 目录轴的显示标签
				"金额(单位元)", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);
		// 从这里开始
		CategoryPlot plot = chart.getCategoryPlot();// 获取图表区域对象
		CategoryAxis domainAxis = plot.getDomainAxis(); // 水平底部列表
		domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 1)); // 水平底部标题
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
		ValueAxis rangeAxis = plot.getRangeAxis();// 获取柱状
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体

		// 到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
		// 在柱体的上面显示数据
		BarRenderer custombarrenderer3d = new BarRenderer();
		custombarrenderer3d.setBaseItemLabelPaint(Color.BLACK);// 数据字体的颜色
		custombarrenderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		custombarrenderer3d.setBaseItemLabelsVisible(true);
		plot.setRenderer(custombarrenderer3d);
		ChartPanel frame1 = new ChartPanel(chart, true); // 这里也可以用chartFrame,可以直接生成一个独立的Frame
		return frame1;
	}

	public DefaultCategoryDataset getDefaultCategoryDataset(List<FinandetailCustomer> searchCharByNeay) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<CharModel> modelList = new ArrayList<>();
		modelList.add(new CharModel("一月", "收入", 0));
		modelList.add(new CharModel("一月", "支出", 0));
		modelList.add(new CharModel("一月", "净收入", 0));

		modelList.add(new CharModel("二月", "收入", 0));
		modelList.add(new CharModel("二月", "支出", 0));
		modelList.add(new CharModel("二月", "净收入", 0));

		modelList.add(new CharModel("三月", "收入", 0));
		modelList.add(new CharModel("三月", "支出", 0));
		modelList.add(new CharModel("三月", "净收入", 0));

		modelList.add(new CharModel("四月", "收入", 0));
		modelList.add(new CharModel("四月", "支出", 0));
		modelList.add(new CharModel("四月", "净收入", 0));

		modelList.add(new CharModel("五月", "收入", 0));
		modelList.add(new CharModel("五月", "支出", 0));
		modelList.add(new CharModel("五月", "净收入", 0));

		modelList.add(new CharModel("六月", "收入", 0));
		modelList.add(new CharModel("六月", "支出", 0));
		modelList.add(new CharModel("六月", "净收入", 0));

		modelList.add(new CharModel("七月", "收入", 0));
		modelList.add(new CharModel("七月", "支出", 0));
		modelList.add(new CharModel("七月", "净收入", 0));

		modelList.add(new CharModel("八月", "收入", 0));
		modelList.add(new CharModel("八月", "支出", 0));
		modelList.add(new CharModel("八月", "净收入", 0));

		modelList.add(new CharModel("九月", "收入", 0));
		modelList.add(new CharModel("九月", "支出", 0));
		modelList.add(new CharModel("九月", "净收入", 0));

		modelList.add(new CharModel("十月", "收入", 0));
		modelList.add(new CharModel("十月", "支出", 0));
		modelList.add(new CharModel("十月", "净收入", 0));

		modelList.add(new CharModel("十一月", "收入", 0));
		modelList.add(new CharModel("十一月", "支出", 0));
		modelList.add(new CharModel("十一月", "净收入", 0));

		modelList.add(new CharModel("十二月", "收入", 0));
		modelList.add(new CharModel("十二月", "支出", 0));
		modelList.add(new CharModel("十二月", "净收入", 0));

		// 先得到一月的数据
		for (FinandetailCustomer find : searchCharByNeay) {
			String month = DateUtil.DateToMonth("yyyy-MM-dd", find.getCreatetime());
			// 这里计算收入总和
			double inMonery = 0;
			double outMonery = 0;
			if (CheckDataUtil.checkisEqual(find.getFatherid(), 1)) {
				inMonery = find.getMonery();
			} else {
				outMonery = find.getMonery();
			}
			for (CharModel charData : modelList) {
				if (charData.getMonth().equals(month) && charData.getType().equals("收入")) {
					charData.setTotal(inMonery + charData.getTotal());
				}
				if (charData.getMonth().equals(month) && charData.getType().equals("支出")) {
					charData.setTotal(outMonery + charData.getTotal());
				}
				if (charData.getMonth().equals(month) && charData.getType().equals("净收入")) {
					charData.setTotal(inMonery - outMonery + charData.getTotal());
				}

			}

		}

		for (CharModel data : modelList) {

			dataset.addValue(data.getTotal(), data.getType(), data.getMonth());
		}

		return dataset;
	};

	public static void main(String[] args) {
		try {
			// 种类数据集
			DefaultCategoryDataset ds = new DefaultCategoryDataset();
			ds.setValue(100, "ibm", "第一季度");
			ds.setValue(200, "ibm", "第二季度");
			ds.setValue(600, "ibm", "第三季度");
			ds.setValue(500, "google", "第一季度");
			ds.setValue(333, "google", "第二季度");
			ds.setValue(780, "google", "第三季度");
			ds.setValue(600, "用友", "第一季度");
			ds.setValue(1500, "用友", "第二季度");
			ds.setValue(300, "用友", "第三季度");
			Font font = new Font("宋体", Font.BOLD, 20);
			// 创建柱状图,柱状图分水平显示和垂直显示两种
			JFreeChart chart = ChartFactory.createBarChart("前三季度各大公司JEEAS市场销售情况", "季度", "销量(万台)", ds,
					PlotOrientation.VERTICAL, true, true, true);
			// 设置整个图片的标题字体
			chart.getTitle().setFont(font);
			// 设置提示条字体
			chart.getLegend().setItemFont(font);
			// 得到绘图区
			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			// 得到绘图区的域轴(横轴),设置标签的字体
			plot.getDomainAxis().setLabelFont(font);
			// 设置横轴标签项字体
			plot.getDomainAxis().setTickLabelFont(font);
			// 设置范围轴(纵轴)字体
			plot.getRangeAxis().setLabelFont(font);
			// 存储成图片
			// 设置chart的背景图片
			// chart.setBackgroundImage(ImageIO.read(new
			// File("d:/sunset.bmp")));
			// plot.setBackgroundImage(ImageIO.read(new File("d:/Water.jpg")));
			plot.setForegroundAlpha(1.0f);
			// ChartUtilities.saveChartAsJPEG(new File("d:/bar.jpg"), chart,
			// 1200, 1200);
			
			
			BufferedImage bi = chart.createBufferedImage(2400, 1200, 2400, 1200, null);
			// BufferedImage bi = new BufferedImage(frame.getWidth(),
			// frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = (Graphics2D) bi.getGraphics();
			g2.setBackground(Color.WHITE);// 设置背景色
			// g2.clearRect(0, 0, 111, 111);//通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
			g2.setPaint(Color.BLUE);// 设置画笔,设置Paint属性
			//ImageIO.write(bi, "png", new File(chartPath + "ddd.png"));
			g2.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * JFrame frame=new JFrame("Java数据统计图"); frame.setLayout(new
	 * GridLayout(1,1,10,10)); ChartPanel charPanel =
	 * createCharPanel(searchCharByNeay , yearString); frame.add(charPanel);
	 * frame.setBounds(20, 20, 1200, 1200); frame.setVisible(true);
	 * BufferedImage bi = new BufferedImage(frame.getWidth(), frame.getHeight(),
	 * BufferedImage.TYPE_INT_ARGB); Graphics2D g2d = bi.createGraphics();
	 * frame.paint(g2d); try { ImageIO.write(bi, "PNG", new File( chartPath +
	 * userid+ "_" + yearString + ".png" )); } catch (IOException e) {
	 * e.printStackTrace(); } String returnPath = returnChartPaht + userid+ "_"
	 * + yearString + ".png" ;
	 * 
	 * chartPanelService.createMyChartPanel(userid , returnPath ,yearString);
	 */
	
	
	
	public DefaultCategoryDataset getMontherDataSet(List<FinandetailCustomer> searchCharByNeay) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<CharModel> modelList = new ArrayList<>();
		modelList.add(new CharModel("5", "收入", 0));
		modelList.add(new CharModel("5", "支出", 0));
		modelList.add(new CharModel("5", "净收入", 0));

		modelList.add(new CharModel("10", "收入", 0));
		modelList.add(new CharModel("10", "支出", 0));
		modelList.add(new CharModel("10", "净收入", 0));

		modelList.add(new CharModel("15", "收入", 0));
		modelList.add(new CharModel("15", "支出", 0));
		modelList.add(new CharModel("15", "净收入", 0));

		modelList.add(new CharModel("20", "收入", 0));
		modelList.add(new CharModel("20", "支出", 0));
		modelList.add(new CharModel("20", "净收入", 0));

		modelList.add(new CharModel("25", "收入", 0));
		modelList.add(new CharModel("25", "支出", 0));
		modelList.add(new CharModel("25", "净收入", 0));

		modelList.add(new CharModel("31", "收入", 0));
		modelList.add(new CharModel("31", "支出", 0));
		modelList.add(new CharModel("31", "净收入", 0));


		// 先得到一月的数据
		for (FinandetailCustomer find : searchCharByNeay) {
			//String month = DateUtil.DateToMonth("yyyy-MM-dd", find.getCreatetime());
			int day = DateUtil.DateToOneDay("yyyy-MM-dd", find.getCreatetime());
			// 这里计算收入总和
			double inMonery = 0;
			double outMonery = 0;
			if (CheckDataUtil.checkisEqual(find.getFatherid(), 1)) {
				inMonery = find.getMonery();
			} else {
				outMonery = find.getMonery();
			}
			for (CharModel charData : modelList) {
				
				// 拿到当前的日期
				int currentDate = Integer.parseInt( charData.getMonth() ) ;
				
				if (( 0+day )<currentDate 
									&& currentDate <= (5+day) 
									&& charData.getType().equals("收入")) {
					charData.setTotal(inMonery + charData.getTotal());
				}
				if (( 0+day )<currentDate 
						&& currentDate <= (5+day) 
						&& charData.getType().equals("支出")) {
					charData.setTotal(outMonery + charData.getTotal());
				}
				if (( 0+day )<currentDate 
						&& currentDate <= (5+day) 
						&& charData.getType().equals("净收入")) {
					charData.setTotal(inMonery - outMonery + charData.getTotal());
				}

			}

		}

		for (CharModel data : modelList) {

			dataset.addValue(data.getTotal(), data.getType(), data.getMonth());
		}

		return dataset;
	}
	
	/**获取图片路径**/
	public String SearchImageContentPath () {
		String contentPath =  request.getSession().getServletContext().getRealPath("/img");
		contentPath = contentPath.replace("\\", "/");
		return contentPath+"/";
	}

}
