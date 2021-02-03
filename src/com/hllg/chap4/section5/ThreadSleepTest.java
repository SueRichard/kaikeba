package com.hllg.chap4.section5;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  16:50
 */
public class ThreadSleepTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            //单位毫秒，静态方法调用
            Thread.sleep(1000);
        }
    }
}
