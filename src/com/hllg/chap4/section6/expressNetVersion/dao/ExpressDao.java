package com.hllg.chap4.section6.expressNetVersion.dao;

import com.hllg.chap4.section6.expressNetVersion.entity.Express;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/08  Mon  07:26
 * 所有express的对外接口方法
 */
public interface ExpressDao {

    List<Express> query();

    boolean delete(String num);

    Express update(Express oldExpress, Express newExpress);

    int initCode();

    Express findByCode(int code);

    int initLocation();

    boolean findByLocation(int loc);

    Express findByNum(String num);

    int findIndexByNum(String num);

    boolean pickExpress(int code);

    Express add(Express express);

    boolean checkFull();
}
