package com.potato.entity;

/**
 * @Author potato
 * @PackageName:com.potato.entity
 * @Description:  TODO 客户
 * @Date 2022-12-10 21:27
 */

public class Client   {
    /**
     * 客户编号
     */
    private int clientId;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 客户性别
     */
    private String gender;

    /**
     * 客户年龄
     */
    private int age;

    /**
     * 货物id
     */
    private int goodsId;

    /**
     * 货物数量
     */
    private int goodsNum;

    public Client(int clientId) {
        this.clientId = clientId;
    }

    public Client() {
    }

    public Client(int clientId, String name, String gender, int age, int goodsId, int goodsNum) {
        this.clientId = clientId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", goodsId=" + goodsId +
                ", goodsNum=" + goodsNum +
                '}';
    }
}
