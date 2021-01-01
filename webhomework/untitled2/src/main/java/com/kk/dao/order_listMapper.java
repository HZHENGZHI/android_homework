package com.kk.dao;

import com.kk.pojo.order_list;

import java.util.List;
import java.util.Map;

public interface order_listMapper {
    //插入数据
    public void inserdata(Map<String,String> map);
    //搜索用户订单
    public List<order_list> selectuserorder(Map<String,String> map);
    //确认收货后更新用户的sigin
    public void updateusersigin(Map<String,String>map);
    //删除用户的所有订单信息
    public void deluserorderlist(String userid);
}
