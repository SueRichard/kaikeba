package com.hllg.javaBasic.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程不安全
 * 同步代码块和同步方法都属于隐式锁
 * 本节介绍显示锁
 *显示锁与隐式锁区别：
 * https://www.cnblogs.com/kaigejava/p/12710602.html
 * @author HLLG
 * @version 1.0
 * @create 2021-2-4 12:22:45
 */
public class LockTest {
    public static void main(String[] args) {
        //显示锁Lock的子类ReentrantLock
        Runnable r = new Ticket();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }

    static class Ticket implements Runnable {
        private int count = 10;
        //锁标记，注意共有一把锁，自身一个锁没有意义
        //private Lock l = new ReentrantLock(true);
        //传入true表示公平锁
        private Lock l = new ReentrantLock(true);

        @Override
        public void run() {
            while (true) {
                //加锁
                l.lock();
                if (count > 0) {
                    System.out.println("准备出票");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "出票成功，余票为：" + count);
                } else {
                    break;
                }
                //释放锁
                l.unlock();
            }
        }
    }
}
