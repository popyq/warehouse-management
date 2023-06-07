package com.potato.dao;

import com.potato.entity.Client;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.dao
 * @Description: TODO 客户接口
 * @Date 2022-12-10 21:55
 */

public interface ClientDao {

    // 根据客户id查询客户信息
    Client selectClient(int cli);

    //根据一组id查询出货物信息
    List<Client> findBySidList2(List<Integer> cli);

    //更新客户信息
    boolean update(int goodsId ,int goodsNum ,int clientId);

    // 删除客户信息
    boolean deleteClientById(int clientId);
}
