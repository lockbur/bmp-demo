package com.jinyinwu.bpm.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    public static final String USER_STATE_OK = "正常";
    public static final String USER_STATE_DISABLE = "禁用";
    public static final String SESSION_KEY = "curr_user";

    private Integer id;
    private String username;
    private String password;
    private String tel;
    private String createtime;
    private String state;
    private String weixinid;
    private String userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWeixinid() {
        return weixinid;
    }

    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
