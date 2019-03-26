package com.webproject.entity;

import java.util.Date;

public class Montherchartpanel {
    /** 主键*/
    private Long monthid;

    /** 用户id*/
    private Long userid;

    /** 年份*/
    private String year;

    /** 月份*/
    private String month;

    /** 更新时间*/
    private Date updatetime;

    /** 图片地址*/
    private String panelurl;
    
    private String fromDate;
    
    

    public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public Long getMonthid() {
        return monthid;
    }

    public void setMonthid(Long monthid) {
        this.monthid = monthid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPanelurl() {
        return panelurl;
    }

    public void setPanelurl(String panelurl) {
        this.panelurl = panelurl == null ? null : panelurl.trim();
    }
}