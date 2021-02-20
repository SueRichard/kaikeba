package com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/19  Fri  12:42
 * 数据库连接工具类
 */
public class DBUtil {
    /**
     * 定义需要用到的变量、常量
     */
    private Connection c = null;
    private PreparedStatement p = null;
    private ResultSet r = null;
    private int count;
    private static String user;
    private static String pwd;
    private static String url;
    private static String driverClass;
    //德鲁伊连接池对象
    private static DruidDataSource dataSource = new DruidDataSource();

    /**
     * 加载驱动
     * 静态代码块
     */
    static {
        //通过properties文件存放属性文件，
        //ResourceBundle读取，或者反射读取，参考onedrive图片；或properties类完成，参考代码笔记
        ResourceBundle rb = ResourceBundle.getBundle("mysql");
        driverClass = rb.getString("driverClass");
        user = rb.getString("user");
        pwd = rb.getString("pwd");
        url = rb.getString("url");
        /**
         * @Description 配置德鲁伊连接池
         * @Author HLLG
         * @Date 19/02/2021 22:20
         **/
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);
        dataSource.setDriverClassName(driverClass);
        //Class.forName(driverClass);
    }

    /**
     * 获取连接
     * 这里及以下方法用protected是为了后面继承
     * 但我觉得用静态方法或者实现接口比较好，毕竟是单继承
     *
     * @return java.sql.Connection
     * @Author HLLG
     * @Date 19/02/2021 12:50
     **/
    protected Connection getConnection() {
        try {
            //德鲁伊获取连接
            c = dataSource.getConnection();
            //c = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return c;
    }

    /**
     * @param sql
     * @return java.sql.PreparedStatement
     * @Description 获取PreparedStatement
     * @Author HLLG
     * @Date 19/02/2021 12:53
     **/
    protected PreparedStatement getPreparedStatement(String sql) {
        try {
            p = getConnection().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return p;
    }

    /**
     * @param params
     * @return void
     * @Description 设置参数
     * @Author HLLG
     * @Date 19/02/2021 12:56
     **/
    protected void setParam(List params) {
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                //p从1开始
                try {
                    p.setObject(i + 1, params.get(i));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    /**
     * @param sql
     * @param params
     * @return int
     * @Description 增删改
     * @Author HLLG
     * @Date 19/02/2021 13:01
     **/
    protected int update(String sql, List params) {
        getPreparedStatement(sql);
        setParam(params);
        try {
            count = p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    /**
     * @param sql
     * @param params
     * @return java.sql.ResultSet
     * @Description （有参）条件查询
     * @Author HLLG
     * @Date 19/02/2021 13:03
     **/
    protected ResultSet query(String sql, List params) {
        getPreparedStatement(sql);
        setParam(params);
        try {
            r = p.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    /**
     * @param sql
     * @return java.sql.ResultSet
     * @Description （无参）全查询
     * @Author HLLG
     * @Date 19/02/2021 13:03
     **/
    protected ResultSet query(String sql) {
        getPreparedStatement(sql);
        try {
            r = p.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    /**
     * @return void
     * @Description 关闭所有连接
     * @Author HLLG
     * @Date 19/02/2021 13:04
     **/
    protected void closeAll() {
        try {
            if (r != null) {
                r.close();
            }
            if (p != null) {
                p.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
