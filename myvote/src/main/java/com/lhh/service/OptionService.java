package com.lhh.service;

import com.lhh.pojo.Option;
import com.lhh.pojo.Subject;


import java.util.List;

public interface OptionService {
    //根据id查询subject返回一个对象
    Subject subjectbuyid( Integer id);

    //根据subjectbuyid 返回的id查询下面的选项
    List<Option> optionlist(Integer id);

    //查询每个选项的投票数量
    int toupiaos(Integer vsid,Integer vpid);

    //判断用户是否投完票
    boolean count( Integer userid, Integer vsid);
}
