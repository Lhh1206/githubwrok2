package com.lhh.serviceimpl;

import com.lhh.dao.UserDao;
import com.lhh.pojo.User;
import com.lhh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceimpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public boolean zhuce(User user) {
        int zhuce = userDao.zhuce(user);
        return zhuce>0;
    }

    @Override
    public boolean verify(String name) {
        int verify = userDao.verify(name);
        return verify>0;
    }

    @Override
    public User user(String name, String pwd) {
        User user = userDao.user(name, pwd);
        return user;
    }
}
