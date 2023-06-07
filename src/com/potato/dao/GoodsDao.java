package com.potato.dao;
import com.potato.entity.Goods;
import com.potato.entity.PageInfo;

import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.dao
 * @Description: TODO 货物接口
 * @Date 2022-12-05 21:55
 */

public interface GoodsDao {

    //添加货物信息
    boolean save(Goods s);

    //根据id查询货物信息
    Goods findGoodsById(int id);

    //根据一组id查询出货物信息
    List<Goods> findBySidList(List<Integer> sids);

    //更新货物信息
    boolean update(String name ,int num ,int id);

    // 删除货物信息
    boolean deleteGoodsById(int id);

    // 分页查询  有bug 待做
    void selectPage(int uid ,PageInfo pageInfo);
}
