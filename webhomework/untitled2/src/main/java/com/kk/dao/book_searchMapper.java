package com.kk.dao;

import com.kk.pojo.book;
import com.kk.pojo.shopping_car;

import java.util.List;

public interface book_searchMapper {
    //获取所有图书
    public List<book> getallbook();

    public int inserbook(book book);
    //可用于管理员插入书籍信息
    public int updatebook(book book);
    //更新书本数据
    public int delbook(book book);
    //删除数据


    public int addshoppingcar(shopping_car car);
    //插入购物车
    public List<shopping_car> checkIssave(shopping_car car);
    //查看该条书籍是否存在
    public int updatecar(shopping_car car);
    //若存在修改该条书籍的数量即可
}
