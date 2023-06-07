package com.potato.dao;

import com.potato.entity.User;

/**
 * @Author potato
 * @PackageName:com.potato.dao
 * @Description: TODO 用户表接口
 * @Date 2022-12-05 21:45
 */


public interface UserDao {
    //注册
    boolean save(User u);

    //登录
    User login(String username,String password);

    //判断是否被注册根据用户名
    User findByUsername(String username);

    //修改密码
    boolean rePwd(String username,String password);

    // 管理员信息
    User select1(int id);

    // 管理员信息
    User select2(String username);
}
