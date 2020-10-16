package com.lhh.dao;

import com.lhh.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@SuppressWarnings("all")
public interface SubjectDao {
    //查询主页
    List<Subject> list();

    //新增投票标题
    int xinzensubject(@Param("title") String title, @Param("type") Integer type);

    //新增投票选项
    int xinzenoption(@Param("vsid") Integer vsid, @Param("optionname") String optionname, @Param("order") Integer order);

    //查询新增投票标题的id
    int maxid();

    //修改标题
    int updatetitlie(@Param("title") String title, @Param("type") Integer type, @Param("vsid") Integer vsid);

    //删除选项
    int deleteoption(@Param("vsid") Integer vsid);

    //根据条件查询
    List<Subject> subjectbuytj(@Param("subjectname") String subjectname);
}
