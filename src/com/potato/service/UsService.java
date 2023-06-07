package com.potato.service;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.service
 * @Description: TODO
 * @Date 2022-12-04 12:52
 */

public interface UsService {

    //根据管理员id访问数据库JDBC获得货物id集合
    List<Integer> getGoodsIdsByUid(int uid);
    //根据管理员id查询,得到一组clientId
    List<Integer> getGoodsIdsByUid2(int uid);

    // 添加
    boolean updateUid(int uid,int goodsuid);
    // 删除
    boolean deleteId(int gooduid);
    // 删除
    boolean deleteClientId(int clientId);
}
