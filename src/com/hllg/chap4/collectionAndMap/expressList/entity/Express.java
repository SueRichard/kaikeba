package com.hllg.chap4.collectionAndMap.expressList.entity;

/**
 * @author HLLG
 * @version 1.0
 * @create 31/01/2021  22:41
 */
public class Express {
    private String num;
    private String company;
    private int code;
    private int location;

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Express(String num, String company, int code, int location) {
        this.num = num;
        this.company = company;
        this.code = code;
        this.location = location;
    }

    public Express() {
    }

    public Express(String num, String company) {
        this.num = num;
        this.company = company;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "快递信息" +
                "单号：" + num +
                ", 公司：" + company +
                ", 取件码：" + code +
                ", 位置：第" + location / 10 + "排，第" + location % 10 + "列";
    }
}
