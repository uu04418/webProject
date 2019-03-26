package com.webproject.entity;

import java.util.Date;

public class Mychartpanel {
    /** */
    private Long panelid;

    /** 年份*/
    private String yearstring;

    /** 图片url*/
    private String charturl;

    /** 最后一次更新时间*/
    private Date updatetime;

    /** */
    private Long userid;
    
    private String fromDate;
    
    

    public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public Long getPanelid() {
        return panelid;
    }

    public void setPanelid(Long panelid) {
        this.panelid = panelid;
    }

    public String getYearstring() {
        return yearstring;
    }

    public void setYearstring(String yearstring) {
        this.yearstring = yearstring == null ? null : yearstring.trim();
    }

    public String getCharturl() {
        return charturl;
    }

    public void setCharturl(String charturl) {
        this.charturl = charturl == null ? null : charturl.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}