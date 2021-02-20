package com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.dao.impl;

import com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.bean.Department;
import com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.bean.Employee;
import com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.dao.DepartmentDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/18  Thu  20:14
 */
public class DepartmentDaoImplTest {

    @Test
    public void getByDepartmentId() {
        DepartmentDao dao = new DepartmentDaoImpl();
        Department department = dao.getByDepartmentId("策划部");
        System.out.println("部门：" + department.getDepname() + "\t对应id：" + department.getDepid());
        for (Employee e : department.getEmployees()) {
            System.out.println("姓名：" + e.getName() + "，id：" + e.getEmpid() + "，性别：" + e.getSex() + "，生日：" + e.getBirthday() + "，职称：" + e.getTitle());
        }
    }

    @Test
    public void findAll() {
        DepartmentDao dao = new DepartmentDaoImpl();
        List<Employee> all = dao.findAll();
        for (Employee e : all) {
            System.out.println("姓名：" + e.getName() + "，id：" + e.getEmpid() + "，性别：" + e.getSex() + "，生日：" + e.getBirthday() + "，职称：" + e.getTitle()
                    + "，部门id：" + e.getDepartment().getDepid() + "，部门名称：" + e.getDepartment().getDepname());
        }
    }

    /**
     * @Description 用于测试DBUtil工具类
     * @return void
     * @Author HLLG
     * @Date 19/02/2021 13:20
     **/
    @Test
    public void findEmployeeById() {
        DepartmentDao dao = new DepartmentDaoImpl();
        Employee e = dao.findById(1);
        System.out.println("姓名：" + e.getName() + "，id：" + e.getEmpid() + "，性别：" + e.getSex() + "，生日：" + e.getBirthday() + "，职称：" + e.getTitle()
                + "，部门id：" + e.getDepid());
    }
    @Test
    public void getAllEmploy() {
        DepartmentDao dao = new DepartmentDaoImpl();
        List<Employee> allEmployee = dao.getAllEmployee(Employee.class);
        for (Employee e : allEmployee) {
            System.out.println(e);
        }
    }
}