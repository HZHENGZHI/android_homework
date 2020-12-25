package com.kk.dao;

import com.kk.pojo.book_collection;

import java.util.List;
import java.util.Map;

public interface book_collectionMapper {
    //获取用户的收藏列表
    public List<book_collection> getusercollection(String userid);
    //删除用户收藏书籍
    public int delusercollection(Map<String,String>map);
    //插入用户收藏
    public int insertusercollection(book_collection collection);
    //搜索用户收藏中是否存在相同的数据
    public List<book_collection> checksamedata(Map<String,String>map);
}
