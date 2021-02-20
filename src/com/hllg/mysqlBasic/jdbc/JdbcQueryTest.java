package com.hllg.mysqlBasic.jdbc;

import java.sql.*;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/18  Thu  15:24
 * jdbc数据库测试——查询
 */
public class JdbcQueryTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
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
            //创建状态通道（发送sql语句）
            s = conn.createStatement();
            //取结果集
            rs = s.executeQuery("select * from employee");
            while (rs.next()) {
                //getXXX XXX为数据类型，参数是表列名
                System.out.print("编号：" + rs.getInt("empid"));
                System.out.print("，姓名：" + rs.getString("name"));
                System.out.print("，性别：" + rs.getString("sex"));
                System.out.print("，职称：" + rs.getString("name"));
                System.out.print("，生日：" + rs.getDate("birthday"));
                System.out.print("，部门id：" + rs.getInt("depid"));
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                //释放资源
                if (rs != null) {
                    rs.close();
                }
                if (s != null) {
                    s.close();
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
