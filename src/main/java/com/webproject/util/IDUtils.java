package com.webproject.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.jpay.ext.kit.IpKit;
import com.jpay.ext.kit.StrKit;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

/**
 * 各种id生成策略
 */
@SuppressWarnings({ "restriction", "unused", "deprecation" })
public class IDUtils {

	static String[] units = { "", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿" };
	static char[] numArray = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
	static char[] numArraybig = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
	static String[] unitsbig = { "", "拾", "佰", "仟", "萬", "拾萬", "佰萬", "仟萬", "亿", "拾亿", "佰亿", "仟亿", "萬亿" };
	static String[] strArr = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };

	public static List<Integer> houseModel(String s) {

		List<Integer> returnList = new ArrayList<>();
		String[] split = s.split("");
		for (int i = 0; i < split.length; i++) {
			for (int m = 0; m < strArr.length; m++) {
				if (split[i].equals(strArr[m])) {
					returnList.add(m);
				}
			}
			;
		}
		return returnList;
	}

	/** 吧double乘以n转为int **/
	public static Integer doubletoint(double d, int n) {

		if (CheckDataUtil.checkNotEmpty(d)) {
			String prease = d * n + "";
			prease = prease.substring(0, prease.lastIndexOf("."));
			return Integer.parseInt(prease);
		}
		return 0;
	}

	public static String datecompany(Date end, Date start) {
		String str = "";
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(end);
		c2.setTime(start);
		if (c1.getTimeInMillis() < c2.getTimeInMillis())
			return str;
		int year1 = c1.get(Calendar.YEAR);
		int year2 = c2.get(Calendar.YEAR);
		int month1 = c1.get(Calendar.MONTH);
		int month2 = c2.get(Calendar.MONTH);
		int day1 = c1.get(Calendar.DAY_OF_MONTH);
		int day2 = c2.get(Calendar.DAY_OF_MONTH);
		// 获取年的差值 假设 d1 = 2015-8-16 d2 = 2011-9-30
		int yearInterval = year1 - year2;
		// 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
		if (month1 < month2 || month1 == month2 && day1 < day2)
			yearInterval--;
		if (yearInterval > 0) {
			str = yearInterval + "年";
		}
		int monthInterval = 0;
		if (month1 < month2) {
			monthInterval = (month1 + 12) - month2;
		} else {
			monthInterval = month1 - month2;
		}
		if (day1 < day2)
			monthInterval--;
		if (monthInterval > 0) {
			str = str + monthInterval + "个月";
		}

		return str;
	}

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 如果不足三位前面补0
		String str = millis + String.format("%03d", end3);

		return str;
	}

	/**
	 * 商品id生成
	 */
	public static String genItemId() {
		// 取当前时间的长整形值包含毫秒///////
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		String id = new String(str);
		return id;
	}

	/**
	 * 商品id生成
	 */
	public static String getCentNum() {
		// 取当前时间的长整形值包含毫秒///////
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		String id = new String(str);
		return "QTC" + id;
	}

	public static String foematIntegerbigprices(int num) {
		if (num <= 0) {
			return "零";
		}
		char[] val = String.valueOf(num).toCharArray();
		int len = val.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			String m = val[i] + "";
			int n = Integer.valueOf(m);
			boolean isZero = n == 0;
			String unit = unitsbig[(len - 1) - i];
			if (isZero) {
				if ('0' == val[i - 1]) {
					// not need process if the last digital bits is 0
					continue;
				} else {
					// no unit for 0
					sb.append(numArraybig[n]);
				}
			} else {
				sb.append(numArraybig[n]);
				sb.append(unit);
			}
		}
		String returnstr = sb.toString();
		if (returnstr.endsWith("零")) {
			returnstr = returnstr.substring(0, returnstr.length() - 1);
		}
		return returnstr;
	}

	public static String foematInteger(int num) {
		if (num <= 0) {
			return "";
		}
		char[] val = String.valueOf(num).toCharArray();
		int len = val.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			String m = val[i] + "";
			int n = Integer.valueOf(m);
			boolean isZero = n == 0;
			String unit = units[(len - 1) - i];
			if (isZero) {
				if ('0' == val[i - 1]) {
					// not need process if the last digital bits is 0
					continue;
				} else {
					// no unit for 0
					sb.append(numArray[n]);
				}
			} else {
				sb.append(numArray[n]);
				sb.append(unit);
			}
		}
		String returnstr = sb.toString();
		if (returnstr.endsWith("零")) {
			returnstr = returnstr.substring(0, returnstr.length() - 1);
		}
		if (returnstr.startsWith("一十")) {
			if (returnstr.length() > 1) {
				returnstr = returnstr.substring(1, returnstr.length());
			}
		}
		return returnstr;
	}

	public static String formatDecimal(double decimal) {
		String decimals = String.valueOf(decimal);
		int decIndex = decimals.indexOf(".");
		int integ = Integer.valueOf(decimals.substring(0, decIndex));
		int dec = Integer.valueOf(decimals.substring(decIndex + 1));
		String result = foematInteger(integ) + "." + formatFractionalPart(dec);
		return result;
	}

	public static String formatbigDecimal(double decimal) {
		String decimals = String.valueOf(decimal);
		int decIndex = decimals.indexOf(".");
		int integ = Integer.valueOf(decimals.substring(0, decIndex));
		int dec = Integer.valueOf(decimals.substring(decIndex + 1));
		String result = foematInteger(integ) + "." + formatFractionalPart(dec);
		return result;
	}

	private static String formatFractionalPart(int decimal) {
		char[] val = String.valueOf(decimal).toCharArray();
		int len = val.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int n = Integer.valueOf(val[i] + "");
			sb.append(numArray[n]);
		}
		return sb.toString();
	}

	/*
	 * public static String checkphone(String telephone) { try { String phone =
	 * ""; if (telephone.contains("-")) { phone = telephone.split("-")[1]; }
	 * else { phone = telephone; } Integer.parseInt(phone);
	 * 
	 * if (phone == null || "".equals(phone)) { return ""; } int i =
	 * phone.length(); if (i != 8 && i != 11) { return ""; } return telephone; }
	 * catch (Exception e) { return ""; }
	 * 
	 * }
	 */

	// str 传入的字符串 。
	public static String appendzero(String str, int length) {
		// 第一步判断字符串的长度
		if (str == null) {
			return "";
		}
		if (str.length() >= length) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length - str.length(); i++) {
			sb.append("0");
		}
		sb.append(str);

		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	public static String getxiaoAccessToken(String appID, String appScret) {
		String accessToken = "";
		// 访问微信服务器
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appID + "&secret="
				+ appScret + "&scope=snssapi_base";
		try {
			URL getUrl = new URL(url);
			HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);

			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] b = new byte[size];
			is.read(b);

			String message = new String(b, "UTF-8");
			@SuppressWarnings("static-access")
			net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(message);
			Map<String, Object> map = (Map<String, Object>) jsonobj;
			accessToken = (String) map.get("access_token");
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}

	public static long searchuseridbyrequest(HttpServletRequest request) {
		String userid = (String) request.getAttribute("checkuserid");
		if (!"".equals(userid) && userid != null) {
			return Long.valueOf(userid);
		}
		return -1L;
	}

	/** 获取机器的IP地址 **/
	public static String spbill_create_ip(HttpServletRequest request) {
		String ip = IpKit.getRealIp(request);
		if (StrKit.isBlank(ip)) {
			ip = "127.0.0.1";
		}
		return ip;
	}

	/**
	 * 获取加密后的密码
	 * 
	 * @param password
	 *            : 明文密码
	 **/
	public static String getprivatePassword(String password) {
		if (password == null || "".equals(password))
			return "";
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(password);
			password = new String(b);
		} catch (Exception e) {
			return "";
		}
		password = Sha1.getSha1(password + "_zf");
		return password;
	};

	/** 当用户操作敏感操作时候 需要判断userid 时候需要从请求头部获取Userid **/
	public static Long getUserIdByToken(HttpServletRequest request) {
		Object obj = request.getAttribute("checkuserid");
		Long userid = -1L;
		if (obj == null) {
			return userid;
		}
		try {
			userid = Long.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			return userid;
		}
		return userid;
	}

	public static boolean threedaysafter(Date intime) {
		// intime = new Date();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(intime);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		calendar2.add(Calendar.DATE, 3);
		String three_days_after = sdf2.format(calendar2.getTime());
		three_days_after = three_days_after + " 12:00:00";
		SimpleDateFormat pres = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date da = null;
		try {
			da = pres.parse(three_days_after);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 三天后的时间和当前时间比较。。
		Date now = new Date();
		// 如果当前时间 超过三天后时间 不能退款
		return now.getTime() < da.getTime();
	}

	// 将 s 进行 BASE64 编码
	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
	}

	public static String replacePhoneKongGe(String current) {

		if (CheckDataUtil.checkisEmpty(current))
			return current;
		current = current.replace(" ", "");
		if (current.length() != 11) {
			return "";
		}
		System.out.println(current);
		return current;
	}

	/** 把米转为千米 **/
	public static String mPRETokm(String current) {

		if (CheckDataUtil.checkisEmpty(current)) {
			return current;
		}
		try {
			int i = Integer.parseInt(current);
			if (i >= 1000) {
				current = (i / 1000.0) + "000";
				current = current.substring(0, current.lastIndexOf(".") + 3) + "km";
			} else {
				current = current + "m";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return current;
	}

	public static double doBargin(double total, long m) {
		double s = 0;
		String max_str = "";
		if (m > 1) {
			double max = ((total / m) * (1 + 0.5));
			double min = ((total / m) * (1 - 0.5));
			s = min + new Random().nextFloat() * (max - min);
		} else {
			s = total;
		}
		if (total < s) {
			s = total;
		}
		max_str = String.format("%.1f", s);
		s = Double.valueOf(max_str) * 1.0;
		int totalInt = doubletoint(total, 100);
		int sInt = doubletoint(s, 100);
		if (sInt == 0)
			sInt = 100;
		total = (totalInt - sInt) / 100;

		return total;

	}

	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, +1);// +1今天的时间加一天
		date = calendar.getTime();
		return date;
	}

	public static String getImageName() {
		// 取当前时间的长整形值包含毫秒///////
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		String id = new String(str);
		return id + ".png";
	}

}
