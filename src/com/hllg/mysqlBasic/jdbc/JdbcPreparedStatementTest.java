package com.hllg.mysqlBasic.jdbc;

import java.sql.*;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/18  Thu  15:24
 * 测试预状态通道
 */
public class JdbcPreparedStatementTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动方式一：
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //加载驱动方式二：
            Driver myDriver = new com.mysql.cj.jdbc.Driver();
            //静态方法
            DriverManager.registerDriver(myDriver);
            /**
             * localhost 可以换成对应ip地址
             * Timezone的z小写
             * kaikeba数据库名称
             */
            String url = "jdbc:mysql://localhost:3306/kaikeba?serverTimezone=UTC";
            String userName = "root";
            //// TODO: 19/02/2021
            String password = "";
            //获得链接
            conn = DriverManager.getConnection(url, userName, password);
            String sql = "select * from employee where name=? and sex=?";
            //创建预状态通道
            ps = conn.prepareStatement(sql);
            //下标从1开始，setXXX改为对应数据类型
            ps.setString(1, "hl");
            ps.setString(2, "女");
            //取结果集
            rs = ps.executeQuery();
            while (rs.next()) {
                //getXXX XXX为数据类型，参数是表列名
                System.out.print("编号：" + rs.getInt("empid"));
                System.out.print("，姓名：" + rs.getString("name"));
                System.out.print("，性别：" + rs.getString("sex"));
                System.out.print("，职称：" + rs.getString("title"));
                System.out.print("，生日：" + rs.getDate("birthday"));
                System.out.print("，部门id：" + rs.getInt("depid"));
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                //释放资源
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
