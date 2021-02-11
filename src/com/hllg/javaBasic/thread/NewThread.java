package com.hllg.javaBasic.thread;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  14:34
 * 需要继承thread类才可以
 */
public class NewThread extends Thread {
    //重写父类方法
    @Override
    public void run() {
        //这是一条新的执行路径，触发方式不是调用run方法，而是通过新建对象的start方法启动，该方法run由系统启动，
        //线程共享一个堆内存，但是栈内存独有
        //由一个线程调用的方法，那么这个方法也会执行在这个线程里面，即出栈入栈
        for (int i = 0; i < 10; i++) {
            System.out.println("这是子线程的操作" + i);
        }
    }
}
