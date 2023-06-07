package com.potato.dao;

import com.potato.util.DBUtils;
import com.potato.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author potato
 * @PackageName:com.potato.dao
 * @Description: TODO 用户表接口实现类,操作数据库
 * @Date 2022-12-05 21:45
 */


public class UserDaoImpl implements UserDao {
    //连接对象
    Connection conn=null;
    //语句处理
    PreparedStatement ps=null;
    //结果集
    ResultSet rs=null;

    /**
     * 注册
     * @param u
     * @return
     */
    @Override
    public boolean save(User u) {
        try {
            conn= DBUtils.getConn();
            String sql="insert into warehouse.user(username,password)  values (?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getPassword());
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
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        //1.获得连接对象
        try {
            conn= DBUtils.getConn();
            //2.sql
            String sql="select * from warehouse.user where username=? and password=?";
            //3.获得语句处理对象
            ps=conn.prepareStatement(sql);
            //4.参数赋值
            ps.setString(1,username);
            ps.setString(2,password);
            //5.执行获得结果集
            rs=ps.executeQuery();
            //6.判定迭代
            while(rs.next()){
                User u=new User(rs.getInt("id"), username,password);
                return u;
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
     * 根据管理员账号判断是否被注册
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        //1.获得连接对象
        try {
            conn= DBUtils.getConn();
            //2.sql
            String sql="select * from warehouse.user where username=?";
            //3.获得语句处理对象
            ps=conn.prepareStatement(sql);
            //4.参数赋值
            ps.setString(1,username);
            //5.执行获得结果集
            rs=ps.executeQuery();
            //6.判定迭代
            while(rs.next()){
                User u=new User(rs.getInt("id"), username, rs.getString("password"));
                return u;
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
     * 修改密码
     * @param username
     * @return
     */
    @Override
    public boolean rePwd(String username,String password) {
        try {
            conn=DBUtils.getConn();
            String sql="update warehouse.user set password=? where username=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,username);
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
     * 查询管理员信息
     * @param id
     * @return
     */
    public User select1(int id) {
        //1.获得链接
        try {
            conn=DBUtils.getConn();
            //2.sql语句
            String sql="select * from warehouse.user where id=?";
            //3.获得预编译语句对象
            ps=conn.prepareStatement(sql);
            //4.赋值参数
            ps.setInt(1,id);
            //5.执行操作
            rs=ps.executeQuery();
            //6.通过游标判定是否查询出了数据
            while(rs.next()){
                return rsToUser(rs);
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
     * 查询管理员信息
     * @param name
     * @return
     */
    public User select2(String name) {
        //1.获得链接
        try {
            conn=DBUtils.getConn();
            //2.sql语句
            String sql="select * from warehouse.user where username=?";
            //3.获得预编译语句对象
            ps=conn.prepareStatement(sql);
            //4.赋值参数
            ps.setString(1,name);
            //5.执行操作
            rs=ps.executeQuery();
            //6.通过游标判定是否查询出了数据
            while(rs.next()){
                return rsToUser(rs);
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
     * 封装结果集--->解析为具体的Java对象
     * @param rs
     * @return
     */
    private User rsToUser(ResultSet rs) throws SQLException {
        User s=new User();
        int id1=rs.getInt("id");
        s.setId(id1);
        s.setUsername(rs.getString("username"));
        s.setPassword(rs.getString("password"));
        int age = rs.getInt("age");
        s.setAge(age);
        s.setGender(rs.getString("gender"));
        return s;
    }



}
