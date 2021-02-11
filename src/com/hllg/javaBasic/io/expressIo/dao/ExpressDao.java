package com.hllg.javaBasic.io.expressIo.dao;

import com.hllg.javaBasic.io.expressIo.entity.Express;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author HLLG
 * @version 1.0
 * @create 31/01/2021  22:51
 */
public class ExpressDao implements Serializable {
    private static final int MAX_SIZE = 100;
    private ArrayList<Express> list ;

    public static int getMaxSize() {
        return MAX_SIZE;
    }

    public ArrayList<Express> getList() {
        return list;
    }

    public void setList(ArrayList<Express> list) {
        this.list = list;
    }

    public ArrayList<Express> query() {
        return list;
    }

    public boolean delete(String num) {
        Express e = findByNum(num);
        return list.remove(e);
    }

    public Express update(String oldNum, String newNum, String newComp) {
        Express old = findByNum(oldNum);
        if (old == null) {
            return null;
        }
        Express newExpress = new Express(newNum, newComp);
        newExpress.setCode(initCode());
        newExpress.setLocation(old.getLocation());
        //查找指定元素在list中的位置
        int index = list.indexOf(old);
        //修改指定index的list中元素
        list.set(index, newExpress);
        return newExpress;
    }

    public Express add(String num, String comp) {
        if (list.size() > MAX_SIZE) {
            return null;
        }
        Express test = findByNum(num);
        if (test == null) {
            Express e = new Express(num, comp);
            int location = initLocation();
            e.setLocation(location);
            int code = initCode();
            e.setCode(code);
            list.add(e);
            return e;
        }
        return null;
    }

    private int initCode() {
        int code = 0;
        do {
            code = (int) (Math.random() * 900000 + 100000);
        } while (findByCode(code) != null);
        return code;
    }

    private Express findByCode(int code) {
        for (Express e : list) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    private int initLocation() {
        int loc = 0;
        do {
            loc = (int) (Math.random() * MAX_SIZE);
        } while (findByLocation(loc));
        return loc;
    }

    private boolean findByLocation(int loc) {
        for (Express e : list) {
            if (e.getLocation() == loc) {
                return true;
            }
        }
        return false;
    }

    public Express findByNum(String num) {
        for (Express e : list) {
            if (e.getNum().equals(num)) {
                return e;
            }
        }
        return null;
    }

    public boolean pickExpress(int code) {
        Express e = findByCode(code);
        return list.remove(e);
    }
}
