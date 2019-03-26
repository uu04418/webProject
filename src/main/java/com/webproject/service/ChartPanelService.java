package com.webproject.service;

import com.webproject.entity.Montherchartpanel;
import com.webproject.entity.Mychartpanel;
import com.webproject.util.PageResult;

public interface ChartPanelService {
	

	public void createMyChartPanel(Long userid, String returnPath , String yearString);

	public PageResult charList(Mychartpanel search, int page, int rows);

	public void createMyMonthPanel(Long userid, String returnPath, String year, String month);

	public PageResult monthChartlist(Montherchartpanel search, int page, int rows);

}
