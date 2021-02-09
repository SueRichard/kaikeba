package com.hllg.chap4.thread;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  14:24
 */
public class ThreadExtendsTest {
    public static void main(String[] args) {
        //方式一：
//        NewThread t = new NewThread();
//        t.start();
//        for (int i = 0; i < 10; i++) {
//            System.out.println("这是主线程的操作"+i);
//        }
        //方式二：
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("这是子进程" + i);
                }
            }
        }.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("这是主进程" + i);
        }
    }
}
