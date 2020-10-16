package com.lhh.dao;

import com.lhh.pojo.Option;
import com.lhh.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OptionDao {

    //根据id查询subject返回一个对象
    Subject subjectbuyid(@Param("id") Integer id);

    //根据subjectbuyid 返回的id查询下面的选项
    List<Option> optionlist(@Param("id") Integer id);

    //查询每个选项的投票数量
    int toupiaos(@Param("vsid") Integer vsid, @Param("vpid") Integer vpid);

    //判断用户是否投过票
    int count(@Param("userid") Integer userid,@Param("vsid") Integer vsid);
}
