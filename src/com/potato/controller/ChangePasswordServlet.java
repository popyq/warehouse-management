package com.potato.controller;

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
 * @Description: TODO 修改密码
 * @Date 2022-12-05 19:28
 */
@WebServlet("/changePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得参数
        String username=req.getParameter("username");
        String rePwd=req.getParameter("newpwd");
        //访问业务层
        UserService userService=new UserServiceImpl();
        userService.rePwd(username,rePwd);
        // 重定向至退出的servlet
        resp.sendRedirect("logoutServlet");
    }
}

