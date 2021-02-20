package com.hllg.mysqlBasic.jdbc.aircraft.view;

import com.hllg.mysqlBasic.jdbc.aircraft.bean.Flight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/19  Fri  23:27
 */
public class View {
    private static Scanner scan = new Scanner(System.in);

    public void print(String msg) {
        System.out.println(msg);
    }

    public String getStringByMsg(String msg) {
        print(msg);
        return scan.nextLine();
    }

    public void welcome() {
        print("-------------------欢迎使用航班信息管理系统------------------");
    }

    public void bye() {
        print("---------------------欢迎再次使用-------------------------");
    }

    public void mainMenu() {
        print("请选择操作：0.添加航班 1.列出所有航班 2.按起飞时间查询 3.按目的地查询 4.删除航班 5.更新航班 6.离开系统");
    }

    public int getChoice(int max) {
        String choice = getStringByMsg("请在0~" + max + "之间选择");
        int temp = -1;
        try {
            temp = Integer.parseInt(choice.trim());
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        if (temp < 0 || temp > max) {
            return getChoice(max);
        }
        return temp;
    }

    public void displayAll(List<Flight> list) {
        if (list.size() == 0) {
            print("暂无航班信息");
        } else {
            print("编号：\t航班号：\t目的地：\t起飞时间：");
            for (Flight flight : list) {
                int num = flight.getNum();
                //格式化
                String flightNumber = String.format("%03d", num);
                print("\t" + flight.getId() + "\t\t" + flightNumber + "\t\t" + flight.getDestination() + "\t\t" + flight.getStartDate());
            }
        }
    }

    public Flight getNewFlight() {
        Flight flight = new Flight();
        try {
            String num = getStringByMsg("请输入新的航班号：（整型）");
            flight.setNum(Integer.parseInt(num));
            flight.setDestination(getStringByMsg("请输入新的目的地："));
            String date = getStringByMsg("请输入日期：yyyy-MM-dd");
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
            flight.setStartDate(format.parse(date));
        } catch (ParseException e) {
            //e.printStackTrace();
            print("日期格式错误，请重试");
            getNewFlight();
        } catch (NumberFormatException e) {
            System.out.println("请输入整型数字");
            getNewFlight();
        }
        return flight;
    }

    public void printUpdateResult(int update) {
        print(update > 0 ? "修改成功" : "修改失败");
    }

    public void printDeleteResult(int delete) {
        if (delete == 0) {
            printNotFindID();
        }
        print(delete > 0 ? "删除成功" : "删除失败");
    }

    public void printAddResult(int add) {
        print(add > 0 ? "添加成功" : "添加失败");
    }

    public String getUpdateID() {
        return getStringByMsg("请输入需要修改航班的id：");
    }

    public void printNotFindID() {
        print("没有找到对应id，请核对后重新输入");
    }

    public String getDeleteID() {
        return getStringByMsg("请输入需要删除的航班id：");
    }

    public String getDestination() {
        return getStringByMsg("请输入目的地：");
    }

    public String getStartDate() {
        return getStringByMsg("请输入起飞时间：yyyy-MM-dd");
    }

    public void printIncorrectID() {
        print("输入id号非整型数字，请重试");
    }
}
