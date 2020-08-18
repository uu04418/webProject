package com.webproject.entity;

public class House {
    /** */
    private String houseid;

    /** 房间号*/
    private String name;

    /** 水费单价*/
    private Double singlewater;

    /** 电费单价*/
    private Double singlelight;

    /** 楼栋id*/
    private String buildingid;

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid == null ? null : houseid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getSinglewater() {
        return singlewater;
    }

    public void setSinglewater(Double singlewater) {
        this.singlewater = singlewater;
    }

    public Double getSinglelight() {
        return singlelight;
    }

    public void setSinglelight(Double singlelight) {
        this.singlelight = singlelight;
    }

    public String getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(String buildingid) {
        this.buildingid = buildingid == null ? null : buildingid.trim();
    }
}