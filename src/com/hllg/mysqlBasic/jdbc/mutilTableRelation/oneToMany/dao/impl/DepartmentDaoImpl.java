package com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.dao.impl;

import com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.bean.Department;
import com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.bean.Employee;
import com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.dao.DepartmentDao;
import com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.utils.DBUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/18  Thu  18:21
 * 注意继承关系
 */
public class DepartmentDaoImpl extends DBUtil implements DepartmentDao {
    @Override
    public Department getByDepartmentId(String name) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/kaikeba?serverTimezone=UTC";
            String user = "root";
            //// TODO: 20/02/2021  
            String pwd = "";
            c = DriverManager.getConnection(url, user, pwd);
            String sql = "select  e.*,d.depname,d.info from employee e,department d where e.depid=d.depid and d.depname=?";
            ps = c.prepareStatement(sql);
            ps.setString(1, name);
            r = ps.executeQuery();
            Department department = new Department();
            List<Employee> list = new ArrayList<>();
            while (r.next()) {
                department.setDepid(r.getInt("depid"));
                department.setDepname(r.getString("depname"));
                Employee employee = new Employee();
                employee.setEmpid(r.getInt("empid"));
                employee.setName(r.getString("name"));
                employee.setSex(r.getString("sex").charAt(0));
                employee.setTitle(r.getString("title"));
                employee.setBirthday(r.getDate("birthday"));
                employee.setDepid(r.getInt("depid"));
                list.add(employee);
            }
            department.setEmployees(list);
            return department;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (r != null) {
                    r.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/kaikeba?serverTimezone=UTC";
            String user = "root";
            String pwd = "HL.an,yy.09.16";
            c = DriverManager.getConnection(url, user, pwd);
            String sql = "select  e.*,d.depname,d.info from employee e,department d where e.depid=d.depid";
            ps = c.prepareStatement(sql);
            r = ps.executeQuery();
            List<Employee> list = new ArrayList<>();
            while (r.next()) {
                Department department = new Department();
                department.setDepid(r.getInt("depid"));
                department.setDepname(r.getString("depname"));
                Employee employee = new Employee();
                employee.setDepartment(department);
                employee.setEmpid(r.getInt("empid"));
                employee.setName(r.getString("name"));
                employee.setSex(r.getString("sex").charAt(0));
                employee.setTitle(r.getString("title"));
                employee.setBirthday(r.getDate("birthday"));
                employee.setDepid(r.getInt("depid"));
                list.add(employee);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (r != null) {
                    r.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Employee findById(int id) {
        Employee e = new Employee();
        String sql = "select * from employee where empid=? ";
        List list = new ArrayList();
        list.add(id);
        ResultSet rs = query(sql, list);
        try {
            while (rs.next()) {
                e.setEmpid(rs.getInt("empid"));
                e.setName(rs.getString("name"));
                e.setSex(rs.getString("sex").charAt(0));
                e.setTitle(rs.getString("title"));
                e.setBirthday(rs.getDate("birthday"));
                e.setDepid(rs.getInt("depid"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return e;
    }

    @Override
    public List<Employee> getAllEmployee(Class c) {
        String sql = "select * from employee";
        List list = new ArrayList();
        try {
            ResultSet r = query(sql);
            //得到数据库查询结果的列信息
            ResultSetMetaData metaData = r.getMetaData();
            //得到列数
            int columnCount = metaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                //表中的列从1开始
                columnNames[i] = metaData.getColumnName(i + 1);
                System.out.println("第" + (i + 1) + "列名：" + columnNames[i]);
            }
            //获取类中所有方法
            Method[] declaredMethods = c.getDeclaredMethods();
            //开始读取数据
            while (r.next()) {
                //此写法在9过时，请先得到构造方法
                //c.newInstance();
                try {
                    Constructor<Employee> constructor = c.getConstructor();
                    Object e = constructor.newInstance();
                    for (String columnName : columnNames) {
                        //设置方法名
                        String methodName = "set" + columnName;
                        //遍历找到对应的方法
                        M:
                        for (Method declaredMethod : declaredMethods) {
                            if (declaredMethod.getName().equalsIgnoreCase(methodName)) {
                                //移除权限检查
                                //declaredMethod.setAccessible(true);
                                //需要方法对应的参数类型，个数？
                                Class<Employee>[] parameterTypes = (Class<Employee>[]) declaredMethod.getParameterTypes();
                                if (parameterTypes.length != 0) {
                                    for (Class<Employee> parameterType : parameterTypes) {
                                        System.out.println(parameterType.getName());
                                        if (parameterType.getName().equals("char")) {
                                            declaredMethod.invoke(e, r.getObject(columnName).toString().charAt(0));
                                            break M;
                                        }
                                    }
                                    System.out.println(declaredMethod.getName());
                                    declaredMethod.invoke(e, r.getObject(columnName));
                                    break;
                                }
                            }
                        }
                    }
                    list.add(e);
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException noSuchMethodException) {
                    noSuchMethodException.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }
}
