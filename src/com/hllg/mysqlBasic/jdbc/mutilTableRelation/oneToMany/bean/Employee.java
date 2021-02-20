package com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.bean;

import java.sql.Date;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/18  Thu  18:12
 */
public class Employee {
    private int empid;
    private String name;
    private char sex;
    private String title;
    private Date birthday;
    private int depid;
    //多对一：多个人对应同一个部门
    private Department department;

    @Override
    public String toString() {
        if (this.department != null) {
            return "雇员{" +
                    "雇员id：" + empid +
                    ", 姓名：'" + name + '\'' +
                    ", 性别：" + sex +
                    ", 职称：'" + title + '\'' +
                    ", 生日：" + birthday +
                    ", 部门id：" + depid +
                    ", 对应部门：" + department.getDepname() +
                    '}';
        } else {
            return "雇员{" +
                    "雇员id：" + empid +
                    ", 姓名：'" + name + '\'' +
                    ", 性别：" + sex +
                    ", 职称：'" + title + '\'' +
                    ", 生日：" + birthday +
                    ", 部门id：" + depid +
                    '}';
        }
    }

    public Employee() {
    }

    public Employee(int empid, String name, char sex, String title, Date birthday, int depid, Department department) {
        this.empid = empid;
        this.name = name;
        this.sex = sex;
        this.title = title;
        this.birthday = birthday;
        this.depid = depid;
        this.department = department;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }
}
