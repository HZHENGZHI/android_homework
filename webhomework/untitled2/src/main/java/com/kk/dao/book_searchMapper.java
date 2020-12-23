package com.kk.dao;

import com.kk.pojo.book;

import java.util.List;

public interface book_search_interface {
    public List<book> getallbook();
    public int inserbook(book book);
}
