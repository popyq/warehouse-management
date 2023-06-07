package com.potato.service;
import com.potato.entity.User;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.service
 * @Description: TODO 定义用户业务层接口
 * @Date 2022-12-04 12:53
 */
public interface UserService {
    //添加
    boolean add(User u);
    //业务判定:是否被注册
    boolean findByUsername(String username);
    //登录业务
    User login(String username,String password);
    // 修改密码
    boolean rePwd(String username,String newPwd);
    // 管理员信息
    User select1(int id);
    // 管理员信息
    User select2(String username);
}
