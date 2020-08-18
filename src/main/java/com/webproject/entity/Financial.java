package com.webproject.entity;

public class Financial {
    /** */
    private String financialid;

    /** */
    private String fatherid;

    /** 0-移除 1-正常 2-禁用*/
    private Integer type;

    /** 类别名称*/
    private String categoryname;

    public String getFinancialid() {
        return financialid;
    }

    public void setFinancialid(String financialid) {
        this.financialid = financialid == null ? null : financialid.trim();
    }

    public String getFatherid() {
        return fatherid;
    }

    public void setFatherid(String fatherid) {
        this.fatherid = fatherid == null ? null : fatherid.trim();
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