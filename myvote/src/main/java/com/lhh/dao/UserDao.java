package com.lhh.dao;

import com.lhh.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    //登录
    User user(@Param("name") String name, @Param("pwd") String pwd);
    //注册
    int zhuce(User user);
    //验证用户是否存在
    int verify (@Param("name") String name);
}
