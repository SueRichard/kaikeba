package com.hllg.mysqlBasic.jdbc.aircraft.bean;

import java.io.Serial;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/19  Fri  22:38
 */
public class Flight implements Serializable {
    @Serial
    private static final long serialVersionUID = -4542026533781988010L;
    private int id;
    private int num;
    private String destination;
    private Date startDate;

    public Flight() {
    }

    public Flight(int num, String destination, Date startDate) {
        this.num = num;
        this.destination = destination;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "航班信息{" +
                "id号：" + id +
                ", 航班号：" + num +
                ", 目的地：" + destination +
                ", 起飞日期：" + startDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
