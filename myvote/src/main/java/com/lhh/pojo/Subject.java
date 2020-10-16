package com.lhh.pojo;

import java.io.Serializable;

public class Subject implements Serializable {
    Integer vs_id;//自己id
    String vs_title;//主题内容
    Integer vs_type;//选项型 1单选 2多选
     Integer vo_idd; //选项id数
      Integer vi_idd; //投票总数

    public Subject(Integer vs_id, String vs_title, Integer vs_type, Integer vo_idd, Integer vi_idd) {
        this.vs_id = vs_id;
        this.vs_title = vs_title;
        this.vs_type = vs_type;
        this.vo_idd = vo_idd;
        this.vi_idd = vi_idd;
    }

    public Subject() {
        super();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "vs_id=" + vs_id +
                ", vs_title='" + vs_title + '\'' +
                ", vs_type=" + vs_type +
                ", vo_idd=" + vo_idd +
                ", vi_idd=" + vi_idd +
                '}';
    }

    public Integer getVs_id() {
        return vs_id;
    }

    public void setVs_id(Integer vs_id) {
        this.vs_id = vs_id;
    }

    public String getVs_title() {
        return vs_title;
    }

    public void setVs_title(String vs_title) {
        this.vs_title = vs_title;
    }

    public Integer getVs_type() {
        return vs_type;
    }

    public void setVs_type(Integer vs_type) {
        this.vs_type = vs_type;
    }

    public Integer getVo_idd() {
        return vo_idd;
    }

    public void setVo_idd(Integer vo_idd) {
        this.vo_idd = vo_idd;
    }

    public Integer getVi_idd() {
        return vi_idd;
    }

    public void setVi_idd(Integer vi_idd) {
        this.vi_idd = vi_idd;
    }
}
