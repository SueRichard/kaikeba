package com.hllg.javaBasic.thread;

/**
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  15:40
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("打印内容")).start();
        //如果对应函数需要参数，就往括号里放，如果语句不止一个，就用{}，参数案例见另一个，例如：
        new Thread(() -> {
            System.out.println("打印内容");
        }).start();

    }
}
