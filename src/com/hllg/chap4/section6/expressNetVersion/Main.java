package com.hllg.chap4.section6.expressNetVersion;

import com.hllg.chap4.section6.expressNetVersion.Client.ExpressClient;
import com.hllg.chap4.section6.expressNetVersion.entity.Express;
import com.hllg.chap4.section6.expressNetVersion.view.View;

import java.io.*;
import java.util.List;

/**
 * @author HLLG
 * @version 2.0
 * @create 2021年2月2日18:37:10
 */
public class Main {
    static View v = new View();
//    static ExpressDaoImpl expressDaoImpl = new ExpressDaoImpl();
    //final static String PATH = "src/com/hllg/chap4/section6/expressNetVersion/data.txt";
    static ExpressClient client = new ExpressClient();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //getDate();
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
                    client.closeSocket();
                    v.bye();
                    break;
            }
        }

    }

//    private static boolean storeDate() {
//        SocketUtil.submitDate(expressDaoImpl.getList());
//        return true;
//    }

//    private static void getDate() throws IOException {
//        expressDaoImpl.setList(SocketUtil.loadDate());
//    }

    private static void userMenu() throws IOException {
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

    private static void pick() throws IOException {
        int code = v.getCode();
        boolean flag = client.pickExpress(code);
        v.printPickResult(flag);
    }

    private static void courierMenu() throws IOException, ClassNotFoundException {
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

    private static void selectAll() throws IOException, ClassNotFoundException {
        List<Express> list = client.query();
        if (list == null) {
            v.nothing();
        } else {
            v.display(list);
        }
    }

    private static void delete() throws IOException {
        String num = v.getNum();
        boolean result = client.delete(num);
        v.printDeleteResult(result);
    }

    private static void update() throws IOException, ClassNotFoundException {
        String oldNum = v.getNum();
        Express result = client.findByNum(oldNum);
        if (result == null) {
            v.printNotFound();
            return;
        }
        Express newExpress = v.getNewExpress();
        Express e = client.update(new Express(oldNum,null),newExpress);
        v.printUpdateResult(e);
    }

    private static void add() throws IOException, ClassNotFoundException {
        //检查是否满
        if (client.isFull()) {
            v.full();
            return;
        }
        Express e = v.inputExpress();
        //Express e = expressDaoImpl.add(num, comp);
        //交给客户端处理
        Express add = client.addExpress(e);
        v.printAddResult(add);
    }
}
