package com.kk.dao;

import com.kk.pojo.buy_book_time;

import java.util.List;
import java.util.Map;

public interface buy_book_timeMapper {
    //插入数据到表中
    public void insertdata(buy_book_time date);
    //搜索同一时刻下单的信息
    public List<buy_book_time> searchdata(Map<String,String> map);
}
