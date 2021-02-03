package com.hllg.chap4.section5;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  16:05
 */
public class GetAndSetThreadNameTest {
    public static void main(String[] args) {
        //获取当前进程的名字
        System.out.println(Thread.currentThread().getName());
        //不给名字，默认
        new Thread(new MyRunnable()).start();
        //设置名字，方法一
        new Thread(new MyRunnable(),"线程1").start();

        Thread t = new Thread(new MyRunnable());
        //设置名字，方法二
        t.setName("线程2");
        t.start();
    }
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
