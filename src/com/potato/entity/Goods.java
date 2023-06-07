package com.potato.entity;

import java.sql.Timestamp;

/**
 * @Author potato
 * @PackageName:com.potato.entity
 * @Description: TODO 货物信息
 * @Date 2022-12-04 11:52
 */

public class Goods {
    /**
     * 货物id
     */
    private  int id;

    /**
     * 货物名称
     */
    private  String name;

    /**
     * 货物数量
     */
    private  int num;

    /**
     * 货物地址
     */
    private  String site;

    /**
     * 入库时间
     */
    private  Timestamp time;

    public Goods(int id, String name, int num, String site, Timestamp time) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.site=site;
        this.time = time;
    }

    public Goods() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", site='" + site + '\'' +
                ", time=" + time +
                '}';
    }
}
