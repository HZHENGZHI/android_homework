package com.dao;

import com.pojo.user;

import java.util.List;

public interface user_interface {
    //检查登陆
    public List<user> checkuser();
    //注册
    public int resing(user user);
}
