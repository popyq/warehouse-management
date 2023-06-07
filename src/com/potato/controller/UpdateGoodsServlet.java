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
 * @Description: TODO 更新货物信息
 * @Date 2022-12-05 17:19
 */
@WebServlet("/updateGoodsServlet")
public class UpdateGoodsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得货物id
        Integer id=Integer.parseInt(req.getParameter("id"));
        // 获取名称
        String name =req.getParameter("name");
        // 获取数量
        Integer num=Integer.parseInt(req.getParameter("num"));
        //访问业务层
        GoodsService goodsService=new GoodsServiceImpl();
        goodsService.update(name, num, id);

        // 修改之后更新session
        new UpdateInformation().UpdateGoodsSession(req);
        resp.sendRedirect("/goods_list.jsp");

    }

}
