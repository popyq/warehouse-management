package com.potato.service;

import com.potato.dao.USDao;
import com.potato.dao.USDaoImpl;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.service
 * @Description: 业务层
 * @Date 2022-12-04 12:53
 */

public class UsServiceImpl implements UsService {

    //业务层依赖于dao层
    USDao usDao=new USDaoImpl();

    @Override
    public List<Integer> getGoodsIdsByUid(int uid) {
        List<Integer> list=usDao.findByUid1(uid);
        return list;
    }

    //根据管理员id查询,得到一组clientId
    @Override
    public List<Integer> getGoodsIdsByUid2(int uid) {
        List<Integer> list = usDao.findByUid2(uid);
        return list;
    }



    // 添加
    @Override
    public boolean updateUid(int uid, int goodsuid) {
        return usDao.updateUid(uid,goodsuid);
    }

    // 删除
    @Override
    public boolean deleteId(int gooduid) {
        return usDao.deleteId(gooduid);
    }

    // 删除
    @Override
    public boolean deleteClientId(int clientId) {
        return usDao.deleteClientId(clientId);
    }

}
