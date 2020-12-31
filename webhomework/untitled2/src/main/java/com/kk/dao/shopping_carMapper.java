package com.kk.dao;

import com.kk.pojo.shopping_car;

import java.util.List;
import java.util.Map;

public interface shopping_carMapper {
    //获取用户的购物车
    public List<shopping_car> getuserdetail(String userid);
    //更新用户购物车
    public int updateuserdetail(Map<String,String>map);
    //结算后进行书籍删除
    public int deluserdetail(shopping_car car);
    //当书本当数目为0时进行删除
    public int deluserbook(Map<String,String>map);
    //删除用户购物车
    public void delusercar(String userid);
}
