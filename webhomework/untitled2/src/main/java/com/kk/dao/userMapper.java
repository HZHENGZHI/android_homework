package com.kk.dao;

import com.kk.pojo.User;

import java.util.List;

public interface user_interface {
    //检查登陆
    public List<User> checkuser(User user);
}
