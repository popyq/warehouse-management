package com.potato.controller;
import com.potato.dao.GoodsDao;
import com.potato.dao.GoodsDaoImpl;
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
 * @Description: TODO 删除货物信息
 * @Date 2022-12-04 16:18
 */

@WebServlet("/deleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获得id
        Integer id=Integer.parseInt(req.getParameter("id"));

        //业务层
        GoodsDao goodsDao=new GoodsDaoImpl();
        goodsDao.deleteGoodsById(id);
        UsServiceImpl usService = new UsServiceImpl();
        usService.deleteId(id);

        // 删除之后更新session
        new UpdateInformation().UpdateGoodsSession(req);
        resp.sendRedirect("/goods_list.jsp");


    }

}
