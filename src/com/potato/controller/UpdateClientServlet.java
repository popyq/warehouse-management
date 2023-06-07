package com.potato.controller;

import com.potato.service.*;
import com.potato.util.UpdateInformation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author potato
 * @PackageName:com.potato.controller
 * @Description: TODO 更新客户信息
 * @Date 2022-12-14 17:09
 */
@WebServlet("/updateClientServlet")
public class UpdateClientServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 修改客户的id
        Integer clientId=Integer.parseInt(req.getParameter("clientId"));
        // 修改客户对应的货物id
        Integer goodsId= Integer.parseInt(req.getParameter("goodsId"));
        // 修改客户需要的货物数量
        Integer goodsNum=Integer.parseInt(req.getParameter("goodsNum"));


        //访问业务层,修改信息
        ClientService clientService= new ClientServiceImpl();
        clientService.update(goodsId, goodsNum, clientId);

        // 修改之后更新session
        new UpdateInformation().UpdateClientSession(req);
        resp.sendRedirect("/client.jsp");

    }



}
