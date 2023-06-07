package com.potato.controller;

import com.alibaba.fastjson.JSON;
import com.potato.service.UserService;
import com.potato.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author potato
 * @PackageName:com.potato.controller
 * @Description: TODO 判断是否注册
 * @Date 2022-12-04 13:42
 */

@WebServlet("/findByUsernameServlet")
public class FindByUsernameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String username=req.getParameter("username");
        //响应输出流
        PrintWriter out=resp.getWriter();
        //访问业务层
        UserService userService=new UserServiceImpl();
        boolean flag=userService.findByUsername(username);
        //输出
        out.println(JSON.toJSONString(flag));
    }
}










