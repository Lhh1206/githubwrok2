package com.lhh.service;

import com.lhh.pojo.User;

public interface UserService {
    User user(String name, String pwd);

    boolean zhuce(User user);

    boolean verify(String name);
}
