package com.potato.dao;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.dao
 * @Description: TODO 关联id表接口
 * @Date 2022-12-05 21:45
 */

public interface USDao {
    //根据当前的管理员id查询出货物id
    //一个用户可能对应多个货物,所以这是一个1对多的关系

    //根据管理员id查询,得到一组id
    List<Integer> findByUid1(int uid);

    //根据管理员id查询,得到一组clientId
    List<Integer> findByUid2(int uid);

    // 添加关联
    boolean updateUid(int uid,int goodsuid);

    // 根据gooduid删除信息
    boolean deleteId(int gooduid);

    // 根据clientId删除信息
    boolean deleteClientId(int clientId);
}
