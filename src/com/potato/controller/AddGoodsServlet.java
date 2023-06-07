package com.potato.controller;

import com.potato.entity.Goods;
import com.potato.service.*;
import com.potato.util.UpdateInformation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author potato
 * @PackageName:com.potato.controller
 * @Description: TODO  添加货物信息
 * @Date 2022-12-04 16:18
 */

@WebServlet("/addGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  获得货物对象
        Goods s=uploadGoods(req);
        //访问业务层,插入货物
        GoodsService songService=new GoodsServiceImpl();
        songService.add(s);

        // 添加关联消息,向关联表中添加信息
        Integer uid=Integer.parseInt(req.getParameter("uid"));
        UsServiceImpl usService = new UsServiceImpl();
        int id = Integer.parseInt(req.getParameter("id"));
        usService.updateUid(uid,id);

        // 添加成功之后更新session
        new UpdateInformation().UpdateGoodsSession(req);
        // 请求转发
        req.getRequestDispatcher("/goods_list.jsp").forward(req,resp);
    }

    /**
     * 获取添加的货物输入对象
     */
    private Goods uploadGoods(HttpServletRequest req) {
        String id=req.getParameter("id");
        int id1 = Integer.parseInt(id);
        String name=req.getParameter("name");
        String num=req.getParameter("num");
        int num1 = Integer.parseInt(num);
        String site = req.getParameter("site");
        //上传时间
        Timestamp uploadTime=new Timestamp(new Date().getTime());
        //构建货物对象
        Goods s=new Goods(id1,name,num1,site,uploadTime);
        return s;
    }


}
