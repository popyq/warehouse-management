package com.potato.util;

import com.potato.entity.Client;
import com.potato.entity.Goods;
import com.potato.entity.User;
import com.potato.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.util
 * @Description: TODO
 * @Date 2022-12-08 17:04
 */

public class UpdateInformation {

    /**
     * 根据管理员id获得货物集合
     * @param id
     * @return
     */
    public List<Goods> findGoodsByid(int id) {
        //访问USService业务层--->货物id的集合
        UsService usService=new UsServiceImpl();
        List<Integer> sids=usService.getGoodsIdsByUid(id);
        //访问SongService业务层--->根据货物id--->货物集合
        GoodsService goodsService=new GoodsServiceImpl();
        List<Goods> goods=goodsService.findByIds(sids);
        return goods;
    }


    /**
     * 通过管理员id返回一个货物集合
     * @param id
     * @return
     */
    public List<Client> findClientByid(int id) {
        //访问USService业务层--->货物id的集合
        UsService usService=new UsServiceImpl();
        List<Integer> sids=usService.getGoodsIdsByUid2(id);
        //访问SongService业务层--->根据货物id--->货物集合
        ClientService clientService=new ClientServiceImpl();
        List<Client> clients= clientService.findByIds(sids);
        return clients;
    }

    /**
     * 更新Client的session
     */
    public void UpdateClientSession(HttpServletRequest req){
        Integer uid=Integer.parseInt(req.getParameter("uid"));
        UserService userService=new UserServiceImpl();
        HttpSession session=req.getSession();
        User u= userService.select1(uid);
        List<Client> client= new UpdateInformation().findClientByid(u.getId());
        session.setAttribute("u",u);
        session.setAttribute("client",client);
    }


    /**
     * 更新goods的session
     * @param req
     */
    public void UpdateGoodsSession(HttpServletRequest req){
        Integer uid=Integer.parseInt(req.getParameter("uid"));
        UserService userService=new UserServiceImpl();
        HttpSession session=req.getSession();
        User u= userService.select1(uid);
        List<Goods> goods=new UpdateInformation().findGoodsByid(u.getId());
        session.setAttribute("u",u);
        session.setAttribute("goods",goods);
    }
}
