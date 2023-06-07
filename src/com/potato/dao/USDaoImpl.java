package com.potato.dao;


import com.potato.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.dao
 * @Description: TODO 关联id表接口实现类,操作数据库
 * @Date 2022-12-05 21:46
 */

public class USDaoImpl implements USDao {

    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    /**
     * 根据管理员id查询,得到一组id
     * @param uid
     * @return
     */
    @Override
    public List<Integer> findByUid1(int uid) {
        List<Integer> sids=new ArrayList<>();
        try {
            conn= DBUtils.getConn();
            String sql="select id from warehouse.goods_id where uid=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,uid);
            rs=ps.executeQuery();
            //迭代
            while(rs.next()){
                sids.add(rs.getInt("id"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return sids;
    }

    /**
     * 根据管理员id查询,得到一组clientId
     * @param uid
     * @return
     */
    @Override
    public List<Integer> findByUid2(int uid) {
        List<Integer> sids=new ArrayList<>();
        try {
            System.out.println("得到的员工"+uid);
            conn= DBUtils.getConn();
            String sql="select clientId from warehouse.goods_id where uid=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,uid);
            rs=ps.executeQuery();
            //迭代
            while(rs.next()){
                sids.add(rs.getInt("clientId"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return sids;
    }


    /**
     * 添加关联
     * @param uid
     * @param goodsuid
     * @return
     */
    @Override
    public boolean updateUid(int uid, int goodsuid) {
        //1.获得连接
        try {
            conn= DBUtils.getConn();
            //2.sql语句
            //update 表 set name=? where id=?;
            String sql="insert into warehouse.goods_id(uid,id) " +
                    "VALUES (?,?)";
            //3.预编译语句处理对象
            ps=conn.prepareStatement(sql);
            //4.参数赋值: 下标值和问号的顺序有关系,问号第几号,下标就是第几,从1开始
            ps.setInt(1,uid);
            ps.setInt(2,goodsuid);
            //5.执行操作
            return ps.executeUpdate()>0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return false;
    }

    /**
     * 根据gooduid删除信息
     * @param gooduid
     * @return
     */
    @Override
    public boolean deleteId(int gooduid) {
        try {
            conn=DBUtils.getConn();
            String sql="delete from warehouse.goods_id where id=? ";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,gooduid);
            System.out.println("结果"+ps.executeUpdate());
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return false;
    }

    /**
     * 根据clientId删除信息
     * @param clientId
     * @return
     */
    @Override
    public boolean deleteClientId(int clientId) {
        try {
            conn=DBUtils.getConn();
            String sql="delete from warehouse.goods_id where clientId=? ";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,clientId);
            return ps.executeUpdate()>1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return false;
    }


}
