package com.kk.dao;

import com.kk.pojo.admin_user;

import java.util.List;

public interface adminMapper {
    //查询是否存在管理员用户名和密码
    public List<admin_user> selectadmin(admin_user admin);
}
