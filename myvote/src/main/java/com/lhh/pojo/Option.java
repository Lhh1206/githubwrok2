package com.lhh.pojo;

import java.io.Serializable;
import java.util.List;

public class Option implements Serializable {
    Integer vo_id;//自己id
    Integer vs_id;//主题id
    String vo_option;//选项内容
    Integer vo_order;//该选项获得的投票数
     Integer piaoshu;   //每个选项的投票总数

    @Override
    public String toString() {
        return "Option{" +
                "vo_id=" + vo_id +
                ", vs_id=" + vs_id +
                ", vo_option='" + vo_option + '\'' +
                ", vo_order=" + vo_order +
                ", piaoshu=" + piaoshu +
                '}';
    }

    public Option(Integer vo_id, Integer vs_id, String vo_option, Integer vo_order, Integer piaoshu) {
        this.vo_id = vo_id;
        this.vs_id = vs_id;
        this.vo_option = vo_option;
        this.vo_order = vo_order;
        this.piaoshu = piaoshu;
    }

    public Option() {
        super();
    }

    public Integer getVo_id() {
        return vo_id;
    }

    public void setVo_id(Integer vo_id) {
        this.vo_id = vo_id;
    }

    public Integer getVs_id() {
        return vs_id;
    }

    public void setVs_id(Integer vs_id) {
        this.vs_id = vs_id;
    }

    public String getVo_option() {
        return vo_option;
    }

    public void setVo_option(String vo_option) {
        this.vo_option = vo_option;
    }

    public Integer getVo_order() {
        return vo_order;
    }

    public void setVo_order(Integer vo_order) {
        this.vo_order = vo_order;
    }

    public Integer getPiaoshu() {
        return piaoshu;
    }

    public void setPiaoshu(Integer piaoshu) {
        this.piaoshu = piaoshu;
    }
}
