package com.potato.dao;

import  com.potato.entity.Goods;
import com.potato.entity.PageInfo;
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
 * @Description: TODO 货物接口实现类,操作数据库
 * @Date 2022-12-05 21:56
 */

public class GoodsDaoImpl implements GoodsDao {

    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    /**
     * 添加货物信息
     * @param g
     * @return
     */
    @Override
    public boolean save(Goods g) {
        //1.获得连接
        try {
            conn= DBUtils.getConn();
            //2.sql语句
            //update 表 set name=? where id=?;
            String sql="insert into warehouse.goods(id,name,num,site,time) " +
                    "VALUES (?,?,?,?,?)";
            //3.预编译语句处理对象
            ps=conn.prepareStatement(sql);
            //4.参数赋值: 下标值和问号的顺序有关系,问号第几号,下标就是第几,从1开始
            setArrtibute(ps,g);
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
     * 根据id查询货物信息
     * @param id
     * @return
     */
    public Goods findGoodsById(int id) {
        //1.获得链接
        try {
            conn=DBUtils.getConn();
            //2.sql语句
            String sql="select * from warehouse.goods where id=?";
            //3.获得预编译语句对象
            ps=conn.prepareStatement(sql);
            //4.赋值参数
            ps.setInt(1,id);
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
     * 将查询到的信息放入list列表中
     * @param sids
     * @return
     */
    @Override
    public List<Goods> findBySidList(List<Integer> sids) {
        List<Goods> goods=new ArrayList<>();
        //循环调用单次查询即可
        for (int i = 0; i <sids.size() ; i++) {
            //根据每个id查询出每个货物
            Goods s=findGoodsById(sids.get(i));
            //将货物添加到新的集合
            goods.add(s);
        }
        return goods;
    }


    /**
     * 根据货物id删除货物
     * @param id
     * @return
     */
    public boolean deleteGoodsById(int id){
        try {
            conn=DBUtils.getConn();
            String sql="delete from warehouse.goods where id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
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
    private Goods rsToSong(ResultSet rs) throws SQLException {
        //移动到当前数据行,一次检索出每一列数据
        Goods s=new Goods();
        //rs.getInt(1);
        //rs.get数据类型("数据库字段名");//返回数据库当前行的列的值
        //将得到的数据 set给Java对象
        int id1=rs.getInt("id");
        s.setId(id1);
        s.setName(rs.getString("name"));
        s.setNum(rs.getInt("num"));
        s.setSite(rs.getString("Site"));
        s.setTime(rs.getTimestamp("time"));
        return s;
    }


    /**
     * 封装参数赋值的操作
     * @param ps
     * @param g
     * @throws SQLException
     */
    private void setArrtibute(PreparedStatement ps, Goods g) throws SQLException {
        ps.setInt(1,g.getId());
        ps.setString(2,g.getName());
        ps.setInt(3,g.getNum());
        ps.setString(4,g.getSite());
        ps.setTimestamp(5,g.getTime());
    }


    /**
     * 更新货物信息
     * @param name
     * @param num
     * @param id
     * @return
     */
    public boolean update(String name ,int num ,int id){
        try {
            conn=DBUtils.getConn();
            String sql="update warehouse.goods set name=?,num=? where id =?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,num);
            ps.setInt(3,id);
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
     * 查询全部数据-分页操作
     * @return
     */
    @Override
    public void selectPage( int uid , PageInfo pageInfo) {
        List list=new ArrayList();
        //1.获得连接
        try {
            conn=DBUtils.getConn();
            //2.sql
            String sql="select * from warehouse.goods where id=? limit ?,?";
            //3.语句处理对象
            ps=conn.prepareStatement(sql);
            //4.参数赋值
            ps.setInt(1,uid);
            ps.setInt(2,(pageInfo.getCurrentPage()-1)*pageInfo.getRecordSize());
            System.out.println((pageInfo.getCurrentPage() - 1) * pageInfo.getRecordSize()+"asdf");
            ps.setInt(3,pageInfo.getRecordSize());
            //5.执行操作,获得结果集
            rs=ps.executeQuery();
            //6.循环--每一行都是Song,多行就是List
            while (rs.next()){
                Goods g=rsToSong(rs);
                //放入集合
                list.add(g);
            }
            pageInfo.setList(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
    }
}
