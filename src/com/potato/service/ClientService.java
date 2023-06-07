package com.potato.service;

import com.potato.entity.Client;
import com.potato.entity.Goods;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.service
 * @Description: TODO 定义客户业务层接口
 * @Date 2022-12-10 22:22
 */
public interface ClientService {

    // 根据客户id查询客户信息
    Client selectClient(int cli);

    //根据一组id查询出货物信息
    List<Client> findByIds(List<Integer> ids);

    //更新客户信息
    boolean update(int goodsId ,int goodsNum ,int clientId);

    // 删除客户信息
    boolean deleteClientById(int clientId);
}
