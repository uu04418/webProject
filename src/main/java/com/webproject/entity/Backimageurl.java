package com.webproject.entity;

public class Backimageurl {
    /** */
    private Long imageid;

    /** 图片地址*/
    private String iamgename;

    /** 图片描述*/
    private String descname;
    
    private String url ;
    

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getImageid() {
        return imageid;
    }

    public void setImageid(Long imageid) {
        this.imageid = imageid;
    }

    public String getIamgename() {
        return iamgename;
    }

    public void setIamgename(String iamgename) {
        this.iamgename = iamgename == null ? null : iamgename.trim();
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }
}