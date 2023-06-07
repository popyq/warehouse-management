package com.potato.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author potato
 * @PackageName:com.potato.controller
 * @Description: TODO  退出登录(清空会话)
 * @Date 2022-12-04 16:15
 */

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得会话
        HttpSession session=req.getSession();
        // 清空session
        session.invalidate();
        resp.setContentType("text/html;charset=utf-8");
        // 重定向至登录页面
        resp.sendRedirect("login.html");
    }
}
