package com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.dao;

import com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.bean.Department;
import com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.bean.Employee;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/18  Thu  18:14
 */
public interface DepartmentDao {
    public Department getByDepartmentId(String name);
    List<Employee> findAll();
    //用于测试工具类
    Employee findById(int id);
    //用于测试反射处理结果集
    List<Employee> getAllEmployee(Class c);
}
