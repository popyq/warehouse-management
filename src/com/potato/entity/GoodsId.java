package com.potato.entity;

/**
 * @Author potato
 * @PackageName:com.potato.entity
 * @Description:  TODO  管理员Id对应的货物ID (一个管理员ID可以对应多个货物ID)
 * @Date 2022-12-04 11:53
 */

public class GoodsId {
    /**
     * 货物id
     */
    private int id;

    /**
     * 管理员id
     */
    private int uid;

    /**
     * 客户id
     */
    private int clientId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "GoodsId{" +
                "id=" + id +
                ", uid=" + uid +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
