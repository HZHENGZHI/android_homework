package com.kk.dao;

import com.kk.pojo.shopping_address;

import java.util.Map;

public interface shopping_addressMapper {
    //用于查找用户当前正在使用的地址
    public shopping_address selectcurrentaddress(Map<String,String>map);
}
