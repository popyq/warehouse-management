package com.potato.service;

import com.potato.entity.Goods;
import com.potato.entity.PageInfo;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.service
 * @Description: TODO  定义货物业务层接口
 * @Date 2022-12-04 12:53
 */

public interface GoodsService {

    //根据货物单个id查询货物信息
    Goods findById(int sid);

    //根据货物id集合查询货物信息
    List<Goods> findByIds(List<Integer> ids);

    //添加货物
    boolean add(Goods s);

    // 删除货物
    boolean delete(int id);

    //更新
    boolean update(String name ,int num ,int id);

    // 分页查询  有bug 待做
    void selectPage(int uid ,PageInfo pageInfo);

}
