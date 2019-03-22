package com.webproject.entity;

import java.util.Date;

public class Loginuser {
    /** 用户主键*/
    private String userid;

    /** 登录账号*/
    private String username;

    /** 登录密码*/
    private String password;

    /** 联系电话*/
    private String telephone;

    /** 注册时间*/
    private Date registime;

    /** 最后一次登录时间*/
    private Date lastgoin;

    /** 用户状态*/
    private Integer state;

    /** */
    private String avatar;

    /** 用户类型 0-超级用户 1-管理员 2-普通用户*/
    private Integer type;

    private String newword;
    
    public String getNewword() {
		return newword;
	}

	public void setNewword(String newword) {
		this.newword = newword;
	}

	public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getRegistime() {
        return registime;
    }

    public void setRegistime(Date registime) {
        this.registime = registime;
    }

    public Date getLastgoin() {
        return lastgoin;
    }

    public void setLastgoin(Date lastgoin) {
        this.lastgoin = lastgoin;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}