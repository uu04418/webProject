package com.webproject.entity;

import java.util.Date;

public class Finandetail {
    /** 财务统计主键*/
    private Long finandetailid;

    /** 统计人id*/
    private Long userid;

    /** 财务类型主键*/
    private Long financialid;

    /** 金额*/
    private Integer monery;

    /** 描述*/
    private String descname;

    /** 创建时间*/
    private Date createtime;

    /** 0-正常 1-删除*/
    private Integer state;
    
    private String mytime ;
    

    public String getMytime() {
		return mytime;
	}

	public void setMytime(String mytime) {
		this.mytime = mytime;
	}

	public Long getFinandetailid() {
        return finandetailid;
    }

    public void setFinandetailid(Long finandetailid) {
        this.finandetailid = finandetailid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getFinancialid() {
        return financialid;
    }

    public void setFinancialid(Long financialid) {
        this.financialid = financialid;
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
}