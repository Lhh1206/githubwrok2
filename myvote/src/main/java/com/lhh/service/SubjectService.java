package com.lhh.service;

import com.github.pagehelper.PageInfo;

import java.util.Map;

@SuppressWarnings("all")
public interface SubjectService {

    PageInfo list(Map<String, Object> map);

    //新增投票标题
    boolean xinzensubject(String title, Integer type);

    //新增投票选项
    boolean xinzenoption(Integer vsid, String optionname, Integer order);

    //查询新增投票标题的id
    int maxid();

    //修改标题
    boolean updatetitlie(String title, Integer type, Integer vsid);

    //删除选项
    boolean deleteoption(Integer vsid);

    //根据条件查询
    PageInfo subjectbuytj(Map<String, Object> map);
}
