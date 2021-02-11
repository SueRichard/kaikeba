package com.hllg.javaBasic.thread;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  14:56
 */
public class RunnableTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("这是通过runnable实现的子进程" + i);
        }
    }
}
