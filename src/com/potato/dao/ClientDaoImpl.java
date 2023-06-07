package com.potato.dao;

import com.potato.entity.Client;
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
 * @Description: TODO 客户实现接口,操作数据库
 * @Date 2022-12-10 21:56
 */

public class ClientDaoImpl implements ClientDao{

    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    /**
     * 根据客户id查询客户信息
     * @param cli
     * @return
     */
    @Override
    public Client selectClient(int cli) {
        //1.获得链接
        try {
            conn= DBUtils.getConn();
            //2.sql语句
            String sql="select * from warehouse.client where clientId=?";
            //3.获得预编译语句对象
            ps=conn.prepareStatement(sql);
            //4.赋值参数
            ps.setInt(1,cli);
            //5.执行操作
            rs=ps.executeQuery();
            //6.通过游标判定是否查询出了数据,此处可以使用if判定,因为id不重复
            while(rs.next()){
                return rsToSong(rs);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return null;
    }

    /**
     * 将查询到的信息封装到list列表中
     * @param clis
     * @return
     */
    @Override
    public List<Client> findBySidList2(List<Integer> clis) {

        List<Client> client=new ArrayList<>();
        //循环调用单次查询即可
        for (int i = 0; i <clis.size() ; i++) {
            //根据每个id查询出每个货物
            Client s= selectClient(clis.get(i));
            //将货物添加到新的集合
            client.add(s);
        }
        return client;
    }


    /**
     * 更新客户信息
     * @param goodsId
     * @param goodsNum
     * @param clientId
     * @return
     */
    public boolean update(int goodsId ,int goodsNum ,int clientId){
        try {
            conn=DBUtils.getConn();
            String sql="update warehouse.client set goodsId=?,goodsNum=? where clientId =?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,goodsId);
            ps.setInt(2,goodsNum);
            ps.setInt(3,clientId);
            return ps.executeUpdate()>0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,null);
        }
        return false;
    }


    /**
     * 根据客户编号删除客户
     * @param clientId
     * @return
     */
    public boolean deleteClientById(int clientId){
        try {
            conn=DBUtils.getConn();
            String sql="delete from warehouse.client where clientId=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,clientId);
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
     * 封装结果集--->解析为具体的Java对象
     * @param rs
     * @return
     */
    private Client rsToSong(ResultSet rs) throws SQLException {
        //移动到当前数据行,一次检索出每一列数据
        Client c= new Client();
        c.setClientId(rs.getInt("clientId"));
        c.setName(rs.getString("name"));
        c.setGender(rs.getString("gender"));
        c.setGoodsId(rs.getInt("goodsId"));
        c.setAge(rs.getInt("age"));
        c.setGoodsNum(rs.getInt("goodsNum"));
        return c;
    }


    /**
     * 封装参数赋值的操作
     * @param ps
     * @param c
     * @throws SQLException
     */
    private void setArrtibute(PreparedStatement ps, Client c) throws SQLException {
        ps.setInt(1, c.getClientId());
        ps.setString(2, c.getName());
        ps.setString(3, c.getGender());
        ps.setInt(4,c.getAge());
        ps.setInt(5,c.getGoodsId());
        ps.setInt(6,c.getGoodsNum());
    }


}
