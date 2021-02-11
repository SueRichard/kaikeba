package com.hllg.javaBasic.thread;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  18:25
 */
public class ThreadNotSafeDemo {
    public static void main(String[] args) {
        Runnable r = new Ticket();
        //线程不安全示例
        //三个线程买票，余票为负数
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }

    static class Ticket implements Runnable {
        private int count = 10;

        @Override
        public void run() {
            while (count > 0) {
                System.out.println("准备出票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println("出票成功，余票为：" + count);
            }
        }
    }
}
