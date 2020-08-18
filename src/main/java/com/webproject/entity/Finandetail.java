package com.webproject.entity;

import java.util.Date;

public class Finandetail {
    /** 财务统计主键*/
    private String finandetailid;

    /** 统计人id*/
    private String userid;

    /** 财务类型主键*/
    private String financialid;

    /** 金额*/
    private Integer monery;

    /** 描述*/
    private String descname;

    /** 创建时间*/
    private Date createtime;

    /** 0-正常 1-删除*/
    private Integer state;

    /** */
    private String payexpertid;

    public String getFinandetailid() {
        return finandetailid;
    }

    public void setFinandetailid(String finandetailid) {
        this.finandetailid = finandetailid == null ? null : finandetailid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getFinancialid() {
        return financialid;
    }

    public void setFinancialid(String financialid) {
        this.financialid = financialid == null ? null : financialid.trim();
    }

    public Integer getMonery() {
        return monery;
    }

    public void setMonery(Integer monery) {
        this.monery = monery;
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPayexpertid() {
        return payexpertid;
    }

    public void setPayexpertid(String payexpertid) {
        this.payexpertid = payexpertid == null ? null : payexpertid.trim();
    }
}