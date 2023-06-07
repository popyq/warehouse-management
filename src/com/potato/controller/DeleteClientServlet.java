package com.potato.controller;

import com.potato.dao.ClientDao;
import com.potato.dao.ClientDaoImpl;
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
 * @Description: TODO
 * @Date 2022-12-14 19:37
 */
@WebServlet("/deleteClientServlet")
public class DeleteClientServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得id
        Integer clientId=Integer.parseInt(req.getParameter("clientId"));

        //业务层
        ClientDao clientDao=new ClientDaoImpl();
        clientDao.deleteClientById(clientId);

        // 删除 客户与管理员的联系
        UsServiceImpl usService = new UsServiceImpl();
        usService.deleteClientId(clientId);

        // 删除之后更新session
        new UpdateInformation().UpdateClientSession(req);
        // 重定向
        resp.sendRedirect("/client.jsp");


    }

}
