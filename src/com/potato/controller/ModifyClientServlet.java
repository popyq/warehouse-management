package com.potato.controller;

import com.potato.entity.Client;
import com.potato.service.ClientService;
import com.potato.service.ClientServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author potato
 * @PackageName:com.potato.controller
 * @Description: TODO  修改客户信息
 * @Date 2022-12-14 17:05
 */
@WebServlet("/modifyClientServlet")
public class ModifyClientServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得货物详情id
        Integer clientId=Integer.parseInt(req.getParameter("clientId"));
        //访问业务层
        ClientService clientService= new ClientServiceImpl();
        Client c=clientService.selectClient(clientId);
        req.setAttribute("c",c);
        req.getRequestDispatcher("modify_client.jsp").forward(req,resp);
    }
}
