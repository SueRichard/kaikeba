package com.hllg.chap4.section6.expressNetVersion;

import com.hllg.chap4.section6.expressNetVersion.dao.ExpressDao;
import com.hllg.chap4.section6.expressNetVersion.entity.Express;
import com.hllg.chap4.section6.expressNetVersion.util.Serializable;
import com.hllg.chap4.section6.expressNetVersion.util.SocketUtil;
import com.hllg.chap4.section6.expressNetVersion.view.View;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HLLG
 * @version 2.0
 * @create 2021年2月2日18:37:10
 */
public class Main {
    static View v = new View();
    static ExpressDao expressDao = new ExpressDao();
    final static String PATH = "src/com/hllg/chap4/section6/expressNetVersion/data.txt";

    public static void main(String[] args) throws IOException {
        init();
        v.welcome();
        boolean flag = true;
        while (flag) {
            v.mainMenu();
            int key = v.inputResult(3);
            switch (key) {
                case 1:
                    courierMenu();
                    break;
                case 2:
                    userMenu();
                    break;
                case 3:
                    flag = false;
                    store();
                    v.bye();
                    break;
            }
        }

    }

    private static void store() {

    }

    private static void init() throws IOException {
        expressDao.setList(SocketUtil.loadDate());
    }

    private static void userMenu() {
        boolean flag = true;
        while (flag) {
            v.userMenu();
            int key = v.inputResult(2);
            switch (key) {
                case 1:
                    pick();
                    break;
                case 2:
                    flag = false;
                    v.backPrevious();
                    break;
            }
        }
    }

    private static void pick() {
        int code = v.getCode();
        boolean flag = expressDao.pickExpress(code);
        v.printPickResult(flag);
    }

    private static void courierMenu() {
        boolean flag = true;
        while (flag) {
            v.courierMenu();
            int key = v.inputResult(5);
            switch (key) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    selectAll();
                    break;
                case 5:
                    flag = false;
                    v.backPrevious();
                    break;
            }
        }
    }

    private static void selectAll() {
        List<Express> list = expressDao.query();
        if (list == null) {
            v.nothing();
        } else {
            v.display(list);
        }
    }

    private static void delete() {
        String num = v.getNum();
        boolean result = expressDao.delete(num);
        v.printDeleteResult(result);
    }

    private static void update() {
        String oldNum = v.getNum();
        Express result = expressDao.findByNum(oldNum);
        if (result == null) {
            v.printNotFound();
            return;
        }
        String newNum = v.getNewNum();
        String newComp = v.getNewComp();
        Express e = expressDao.update(oldNum, newNum, newComp);
        v.printUpdateResult(e);
    }

    private static void add() {
        String num = v.getNum();
        String comp = v.getComp();
        Express e = expressDao.add(num, comp);
        v.printAddResult(e);
    }
}
