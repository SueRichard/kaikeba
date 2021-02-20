package com.hllg.mysqlBasic.jdbc.aircraft.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/19  Fri  23:26
 */
public class DBUtil {
    private static Connection c;
    private static PreparedStatement p;
    private static ResultSet r;
    private static String userName;
    private static String password;
    private static String url;
    private static String driverClass;
    private static DruidDataSource dataSource = new DruidDataSource();

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mysql");
        driverClass = resourceBundle.getString("driverClass");
        userName = resourceBundle.getString("user");
        password = resourceBundle.getString("pwd");
        url = resourceBundle.getString("url");
        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        /**
         * 建议配置为true，这里我设置false只是为了去除红字，手动笑哭
         * 参考github：
         * https://github.com/alibaba/druid/wiki/DruidDataSource%E9%85%8D%E7%BD%AE%E5%B1%9E%E6%80%A7%E5%88%97%E8%A1%A8
         */
        //dataSource.setTestWhileIdle(false);
        /**
         * 应该这样设置，请参考上述链接
         */
        dataSource.setValidationQuery("select 'x'");
    }

    public static Connection getConnection() {
        try {
            c = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return c;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            p = getConnection().prepareStatement(sql);
            return p;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void setParameters(List params) {
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                try {
                    p.setObject(i + 1, params.get(i));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public static int update(String sql, List list) {
        getPreparedStatement(sql);
        setParameters(list);
        try {
            return p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static ResultSet queryByConditions(String sql, List list) {
        getPreparedStatement(sql);
        setParameters(list);
        try {
            r = p.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public static ResultSet queryAll(String sql) {
        getPreparedStatement(sql);
        try {
            r = p.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public static void closeAll() {
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
