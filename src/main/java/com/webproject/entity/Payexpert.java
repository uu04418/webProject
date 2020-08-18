package com.webproject.entity;

import java.util.Date;

public class Payexpert {
    /** 分期租赁iD*/
    private String payexpertid;

    /** 房子id*/
    private String houseid;

    /** 分期名称*/
    private String payexpertname;

    /** 账单开始日期*/
    private Date start_time;

    /** 账单结束日期*/
    private Date end_time;

    /** 实收金额*/
    private Double realmonery;

    /** 水初*/
    private Double waterstart;

    /** 水末*/
    private Double waterend;

    /** 电初*/
    private Double lightstart;

    /** 电末*/
    private Double lightend;

    public String getPayexpertid() {
        return payexpertid;
    }

    public void setPayexpertid(String payexpertid) {
        this.payexpertid = payexpertid == null ? null : payexpertid.trim();
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid == null ? null : houseid.trim();
    }

    public String getPayexpertname() {
        return payexpertname;
    }

    public void setPayexpertname(String payexpertname) {
        this.payexpertname = payexpertname == null ? null : payexpertname.trim();
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Double getRealmonery() {
        return realmonery;
    }

    public void setRealmonery(Double realmonery) {
        this.realmonery = realmonery;
    }

    public Double getWaterstart() {
        return waterstart;
    }

    public void setWaterstart(Double waterstart) {
        this.waterstart = waterstart;
    }

    public Double getWaterend() {
        return waterend;
    }

    public void setWaterend(Double waterend) {
        this.waterend = waterend;
    }

    public Double getLightstart() {
        return lightstart;
    }

    public void setLightstart(Double lightstart) {
        this.lightstart = lightstart;
    }

    public Double getLightend() {
        return lightend;
    }

    public void setLightend(Double lightend) {
        this.lightend = lightend;
    }
}