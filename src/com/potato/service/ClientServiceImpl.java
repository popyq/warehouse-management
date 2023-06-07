package com.potato.service;

import com.potato.dao.ClientDao;
import com.potato.dao.ClientDaoImpl;
import com.potato.entity.Client;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.service
 * @Description: TODO  客户业务层
 * @Date 2022-12-10 22:22
 */

public class ClientServiceImpl implements ClientService {

    ClientDao clientDao = new ClientDaoImpl();

    //根据一组id查询出货物信息
    @Override
    public Client selectClient(int cli) {
        return clientDao.selectClient(cli);
    }

    //根据一组id查询出货物信息
    @Override
    public List<Client> findByIds(List<Integer> ids) {
        return clientDao.findBySidList2(ids);
    }

    //更新客户信息
    @Override
    public boolean update(int goodsId, int goodsNum, int clientId) {
        return clientDao.update(goodsId,goodsNum,clientId);
    }

    // 删除客户信息
    @Override
    public boolean deleteClientById(int clientId) {
        return clientDao.deleteClientById(clientId);
    }
}
