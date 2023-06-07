package com.potato.controller;

import com.potato.entity.User;
import com.potato.service.UserService;
import com.potato.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author potato
 * @PackageName:com.potato.controller
 * @Description: TODO  注册
 * @Date 2022-12-04 16:15
 */

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User u= new User(username,password);
        //处理参数-dao--->service
        //依赖的是 service层对象
        UserService userService=new UserServiceImpl();
        boolean flag=userService.add(u);
        //响应
        if(flag){
            // 注册成功跳转至login.html页面
            resp.sendRedirect("login.html");
        }else{
            resp.sendRedirect("reg.html");
        }
    }
}
