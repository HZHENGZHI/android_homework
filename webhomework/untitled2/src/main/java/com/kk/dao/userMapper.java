package com.kk.dao;

import com.kk.pojo.User;
import com.kk.pojo.shopping_address;

import java.util.List;

public interface userMapper {
    //检查登陆
    public List<User> checkuser(User user);
    //获取个人信息
    public User getusermsg(String userid);
    //获取用户的所有地址信息
    public List<shopping_address> getuseraddreess(String userid);
}