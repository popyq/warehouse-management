package com.potato.service;

import com.potato.dao.UserDao;
import com.potato.dao.UserDaoImpl;
import com.potato.entity.User;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.service
 * @Description: TODO 用户业务层
 * @Date 2022-12-04 12:53
 */

public class UserServiceImpl implements UserService {
    //依赖具体的dao层对象
    UserDao userDao=new UserDaoImpl();

    //添加
    @Override
    public boolean add(User u) {
        boolean flag=userDao.save(u);
        return flag;
    }

    //业务判定:是否被注册
    @Override
    public boolean findByUsername(String username) {
        //dao层处理数据--数据库
        User u=userDao.findByUsername(username);

        return u==null;//!
    }

    // 登录
    @Override
    public User login(String username, String password) {
        User u=userDao.login(username,password);
        return u;
    }

    // 修改密码
    @Override
    public boolean rePwd(String username, String newPwd) {
        return userDao.rePwd(username, newPwd);
    }

    // 管理员信息
    @Override
    public User select1(int id) {
        return userDao.select1(id);
    }

    // 管理员信息
    @Override
    public User select2(String name) {
        return userDao.select2(name);
    }



}
