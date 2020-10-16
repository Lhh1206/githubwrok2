package com.lhh.pojo;

import java.io.Serializable;

public class Item implements Serializable {
    Integer vi_id; //自己id
    Integer vu_user_id;//用户id
    Integer vs_id;//主题id
    Integer vo_id;//选项id

    @Override
    public String toString() {
        return "Item{" +
                "vi_id=" + vi_id +
                ", vu_user_id=" + vu_user_id +
                ", vs_id=" + vs_id +
                ", vo_id=" + vo_id +
                '}';
    }

    public Item(Integer vi_id, Integer vu_user_id, Integer vs_id, Integer vo_id) {
        this.vi_id = vi_id;
        this.vu_user_id = vu_user_id;
        this.vs_id = vs_id;
        this.vo_id = vo_id;
    }

    public Item() {
        super();
    }

    public Integer getVi_id() {
        return vi_id;
    }

    public void setVi_id(Integer vi_id) {
        this.vi_id = vi_id;
    }

    public Integer getVu_user_id() {
        return vu_user_id;
    }

    public void setVu_user_id(Integer vu_user_id) {
        this.vu_user_id = vu_user_id;
    }

    public Integer getVs_id() {
        return vs_id;
    }

    public void setVs_id(Integer vs_id) {
        this.vs_id = vs_id;
    }

    public Integer getVo_id() {
        return vo_id;
    }

    public void setVo_id(Integer vo_id) {
        this.vo_id = vo_id;
    }
}
