package com.potato.controller;

import com.potato.entity.Goods;
import com.potato.service.GoodsService;
import com.potato.service.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author potato
 * @PackageName:com.potato.controller
 * @Description: TODO 修改货物信息
 * @Date 2022-12-05 12:17
 */
@WebServlet("/modifyGoodsServlet")
public class ModifyGoodsServlet extends HttpServlet {

        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            //获得货物详情id
            Integer id=Integer.parseInt(req.getParameter("id"));
            //访问业务层
            GoodsService goodsService=new GoodsServiceImpl();
            Goods g=goodsService.findById(id);
            //绑定数据转发到详情页
            req.setAttribute("g",g);
            req.getRequestDispatcher("modify.jsp").forward(req,resp);
        }
    }