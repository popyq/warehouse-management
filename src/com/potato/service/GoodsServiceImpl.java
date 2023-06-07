package com.potato.service;

import com.potato.dao.GoodsDao;
import com.potato.dao.GoodsDaoImpl;
import com.potato.entity.Goods;
import com.potato.entity.PageInfo;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.service
 * @Description: TODO  货物业务层
 * @Date 2022-12-04 12:53
 */

public class GoodsServiceImpl implements GoodsService {

    GoodsDao goodsDao=new GoodsDaoImpl();

    //根据货物单个id查询货物信息
    @Override
    public Goods findById(int sid) {
        Goods s=goodsDao.findGoodsById(sid);
        return s;
    }

    //根据货物id集合查询货物信息
    @Override
    public List<Goods> findByIds(List<Integer> ids) {
        List<Goods> list=goodsDao.findBySidList(ids);
        return list;
    }

    //添加货物
    @Override
    public boolean add(Goods s) {
        return goodsDao.save(s);
    }

    // 删除货物
    @Override
    public boolean delete(int id) {
        return goodsDao.deleteGoodsById(id);
    }
    //更新
    @Override
    public boolean update(String name, int num, int id) {
        return goodsDao.update(name,  num, id);
    }

    // 分页查询  有bug 待做
    @Override
    public void selectPage( int uid ,PageInfo pageInfo) {
        goodsDao.selectPage(uid,pageInfo);
    }

}
