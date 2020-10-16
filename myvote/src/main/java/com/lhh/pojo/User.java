package com.lhh.pojo;

import java.io.Serializable;

public class User implements Serializable {
   Integer    vu_user_id;//自己id
   String    vu_user_name;//用户名
   String    vu_password;//用户密码
   Integer vu_status;//用户角色 1 管理员 2普通用户

    public User(Integer vu_user_id, String vu_user_name, String vu_password, Integer vu_status) {
        this.vu_user_id = vu_user_id;
        this.vu_user_name = vu_user_name;
        this.vu_password = vu_password;
        this.vu_status = vu_status;
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "vu_user_id=" + vu_user_id +
                ", vu_user_name='" + vu_user_name + '\'' +
                ", vu_password='" + vu_password + '\'' +
                ", vu_status=" + vu_status +
                '}';
    }

    public Integer getVu_user_id() {
        return vu_user_id;
    }

    public void setVu_user_id(Integer vu_user_id) {
        this.vu_user_id = vu_user_id;
    }

    public String getVu_user_name() {
        return vu_user_name;
    }

    public void setVu_user_name(String vu_user_name) {
        this.vu_user_name = vu_user_name;
    }

    public String getVu_password() {
        return vu_password;
    }

    public void setVu_password(String vu_password) {
        this.vu_password = vu_password;
    }

    public Integer getVu_status() {
        return vu_status;
    }

    public void setVu_status(Integer vu_status) {
        this.vu_status = vu_status;
    }
}
