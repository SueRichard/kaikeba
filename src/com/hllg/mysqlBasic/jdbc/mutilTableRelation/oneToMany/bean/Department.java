package com.hllg.mysqlBasic.jdbc.mutilTableRelation.oneToMany.bean;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/18  Thu  18:11
 */
public class Department {
    private int depid;
    private String depname;
    private String info;
    //一对多：一个部分对应多个人
    private List<Employee> employees;

    public Department() {
    }

    public Department(int depid, String depname, String info, List<Employee> employees) {
        this.depid = depid;
        this.depname = depname;
        this.info = info;
        this.employees = employees;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
