package com.hllg.chap4.thread;

/**
 * @author HLLG
 * @version 1.0
 * @create 2021-2-4 11:49:57
 */
public class SynchronizedBlockTest {
    public static void main(String[] args) {
        Runnable r = new Ticket();
        //同步代码块
        //synchronized(锁对象){代码块}
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }

    static class Ticket implements Runnable {
        private int count = 10;
        //锁标记，注意共有一把锁，自身一个锁没有意义
        private Object o = new Object();

        @Override
        public void run() {
            //如果把锁写在这里，就是各自一把锁
            //Object o = new Object();
            while (true) {
                synchronized (o) {
                    if (count > 0) {
                        System.out.println("准备出票");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        count--;
                        System.out.println(Thread.currentThread().getName()+"出票成功，余票为：" + count);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
