package com.hllg.chap4.section6.expressNetVersion.dao;

import com.hllg.chap4.section6.expressNetVersion.entity.Express;
import com.hllg.chap4.section6.expressNetVersion.util.IOUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @create 31/01/2021  22:51
 */
public class ExpressDaoImpl implements Serializable, ExpressDao {
    private static final int MAX_SIZE = 100;
    //private ArrayList<Express> list ;
    //多线程需要满足线程安全，选择Collections.synchronizedList(new ArrayList<>())方式
    private List<Express> list = Collections.synchronizedList(new ArrayList<>());

    {
        //初始化读取数据
        list = IOUtils.readFromFile();
    }

    public static int getMaxSize() {
        return MAX_SIZE;
    }

    public List<Express> getList() {
        return list;
    }

    public void setList(List<Express> list) {
        this.list = list;
    }

    @Override
    public List<Express> query() {
        return list;
    }

    @Override
    public boolean delete(String num) {
        Express e = findByNum(num);
        boolean flag = list.remove(e);
        //更改数据写入文件
        IOUtils.writeToFile(list);
        return flag;
    }

    @Override
    public Express update(Express oldExpress, Express newExpress) {
        Express old = findByNum(oldExpress.getNum());
        if (old == null) {
            return null;
        }
        newExpress.setCode(initCode());
        newExpress.setLocation(old.getLocation());
        //查找指定元素在list中的位置
        int index = list.indexOf(old);
        //修改指定index的list中元素
        list.set(index, newExpress);
        IOUtils.writeToFile(list);
        return newExpress;
    }

    @Override
    public Express add(Express e) {
        if (checkFull()) {
            return null;
        }
        Express test = findByNum(e.getNum());
        if (test == null) {
            e.setLocation(initLocation());
            e.setCode(initCode());
            list.add(e);
            IOUtils.writeToFile(list);
            return e;
        }
        return null;
    }

    @Override
    public int initCode() {
        int code = 0;
        do {
            code = (int) (Math.random() * 900000 + 100000);
        } while (findByCode(code) != null);
        return code;
    }

    @Override
    public Express findByCode(int code) {
        for (Express e : list) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    @Override
    public int initLocation() {
        int loc = 0;
        do {
            loc = (int) (Math.random() * MAX_SIZE);
        } while (findByLocation(loc));
        return loc;
    }

    @Override
    public boolean findByLocation(int loc) {
        for (Express e : list) {
            if (e.getLocation() == loc) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Express findByNum(String num) {
        for (Express e : list) {
            if (e.getNum().equals(num)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public int findIndexByNum(String num) {
        for (int i = 0; i < list.size(); i++) {
            if (num.equals(list.get(i).getNum())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean pickExpress(int code) {
        Express e = findByCode(code);
        return list.remove(e);
    }


    @Override
    public boolean checkFull() {
        return list.size() >= MAX_SIZE;
    }
}
