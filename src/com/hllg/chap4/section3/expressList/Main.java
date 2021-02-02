package com.hllg.chap4.section3.expressList;

import com.hllg.chap4.section3.expressList.dao.ExpressDao;
import com.hllg.chap4.section3.expressList.entity.Express;
import com.hllg.chap4.section3.expressList.view.View;

import java.util.ArrayList;

/**
 * @author HLLG
 * @version 1.0
 * @create 31/01/2021  22:52
 */
public class Main {
    static View v = new View();
    static ExpressDao expressDao = new ExpressDao();

    public static void main(String[] args) {
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
                    v.bye();
                    break;
            }
        }

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
        ArrayList<Express> list = expressDao.query();
        v.display(list);
    }

    private static void delete() {
        String num = v.getNum();
        boolean result = expressDao.delete(num);
        v.printDeleteResult(result);
    }

    private static void update() {
        String oldNum = v.getNum();
        Express result = expressDao.findByNum(oldNum);
        if(result == null){
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
