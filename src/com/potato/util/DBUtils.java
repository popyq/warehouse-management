package com.potato.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


/**
 * @Author potato
 * @PackageName:com.potato.util
 * @Description: JDBC连接数据库工具类
 * @Date 2022-12-04 11:52
 */

public class DBUtils {
    //用户名
    static String username=null;
    //密码
    static String pwd=null;
    //驱动地址
    static String driverName=null;
    //url地址
    static String url=null;

    //使用静态的代码块赋值
    static{
        //1.读取配置文件
        try {
            // 运行时记得路径
            FileInputStream in=new FileInputStream(
                    "D:\\Java-idea\\warehouse\\src\\com\\potato\\util\\jdbc.properties");
            //2.通过配置工具类去读取文件信息
            Properties p=new Properties();
            //3.加载
            p.load(in);
            //4.读取数据赋值给全局变量
            username=p.getProperty("username");
            pwd=p.getProperty("pwd");
            url=p.getProperty("url");
            driverName=p.getProperty("driverName");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获得链接
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName(driverName);
        //2获得连接
        return DriverManager.getConnection(url,username,pwd);
    }
    //关闭对象
    public static void close(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 测试
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getConn());
    }
}
