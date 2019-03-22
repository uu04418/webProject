package com.webproject.entity;

public class Financial {
    /** */
    private Long financialid;

    /** */
    private Long fatherid;

    /** 0-移除 1-正常 2-禁用*/
    private Integer type;

    /** 类别名称*/
    private String categoryname;

    public Long getFinancialid() {
        return financialid;
    }

    public void setFinancialid(Long financialid) {
        this.financialid = financialid;
    }

    public Long getFatherid() {
        return fatherid;
    }

    public void setFatherid(Long fatherid) {
        this.fatherid = fatherid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }
}