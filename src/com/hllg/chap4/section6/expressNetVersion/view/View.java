package com.hllg.chap4.section6.expressNetVersion.view;

import com.hllg.chap4.section6.expressNetVersion.entity.Express;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author HLLG
 * @version 1.0
 * @create 31/01/2021  22:51
 */
public class View {
    private Scanner sc = new Scanner(System.in);

    /**
     * 输出指定信息
     *
     * @param msg
     */
    public void print(String msg) {
        System.out.println(msg);
    }

    /**
     * 通过输出提示获取对应输入
     *
     * @param msg
     * @return
     */
    public String getInputByMessage(String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }

    public void welcome() {
        System.out.println("欢迎使用快递柜");
    }

    public void mainMenu() {
        System.out.println("请选择角色：1.快递员 2.用户 3.退出");
    }

    /**
     * 控制选项在合理范围内
     *
     * @param max
     * @return
     */
    public int inputResult(int max) {
        String choice = getInputByMessage("请在1~" + max + "选择");
        int temp = -1;
        try {
            temp = Integer.parseInt(choice);
        } catch (NumberFormatException e) {

        }
        if (temp < 0 || temp > max) {
            //方法一
            //temp = inputResult(max);
            return inputResult(max);
        }
        return temp;
    }

    public void bye() {
        System.out.println("欢迎下次使用，再见！");
    }

    public void userMenu() {
        System.out.println("1.取件 2.返回上一层菜单");
    }

    public void backPrevious() {
        System.out.println("返回上一层");
    }

    public void courierMenu() {
        System.out.println("1.添加快递 2.修改快点 3.删除快递 4.查询所有快递 5.返回上一层菜单");
    }

    public void display(List<Express> list) {
        if (list.size() == 0) {
            print("快递信息为空！");
        } else {
            for (Express e : list
            ) {
                System.out.println(e);
            }
        }
    }

    public String getNum() {
        return getInputByMessage("请输入快递单号：");
    }

    public void printDeleteResult(boolean result) {
        print(result ? "删除成功！" : "删除失败！");
    }

    public String getNewNum() {
        return getInputByMessage("请输入新单号：");
    }

    public String getComp() {
        return getInputByMessage("请输入公司名称：");
    }

    public String getNewComp() {
        return getInputByMessage("请输入新公司名称：");
    }

    public void printUpdateResult(Express e) {
        print("更新成功，新的快递信息为：" + e);
    }

    public void printAddResult(Express e) {
        print(e == null ? "快递柜已满或单号重复" : "添加成功！位置：" + showLocation(e) + "，取件码：" + e.getCode());
    }

    /**
     * 展示位置
     *
     * @param e
     * @return
     */
    private String showLocation(Express e) {
        //注意除数为0，余数为0的情况
        return (e.getLocation() / 10 + 1) + "排" + (e.getLocation() % 10 + 1) + "列";
    }

    public int getCode() {
        int code = 0;
        String temp = getInputByMessage("请输入取件码：");
        try {
            code = Integer.parseInt(temp);
        } catch (NumberFormatException e) {

        }
        return code;
    }

    public void printPickResult(boolean flag) {
        print(flag ? "取件成功！" : "取件失败！请检查取件码！");
    }

    public void printNotFound() {
        print("单号不存在，请核对再次尝试");
    }

    public void nothing() {
        print("快递柜为空，请先存储！");
    }

    public void printStoreResult(boolean storeFlag) {
        System.out.println(storeFlag ? "提交修改成功" : "提交修改失败");
    }

    public Express inputExpress() {
        String num = getInputByMessage("请输入快递单号：");
        String comp = getInputByMessage("请输入快递公司：");
        return new Express(num, comp);
    }

    public void full() {
        print("快递柜已满");
    }

    public Express getNewExpress() {
        String num = getInputByMessage("请输入新的快递单号：");
        String comp = getInputByMessage("请输入新的快递公司：");
        return new Express(num, comp);
    }
}
