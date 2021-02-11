package com.hllg.javaBasic.thread;

/**
 * @author HLLG
 * @version 1.0
 * @create 2021-2-4 11:50:04
 */
public class SynchronizedMethodTest {
    public static void main(String[] args) {
        Runnable r = new Ticket();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }

    static class Ticket implements Runnable {
        private int count = 10;

        @Override
        public void run() {
            //---------------------
            //如果同步代码块锁对象也是this，那么在访问下面代码块，就不能访问synchronized修饰的方法
            /*synchronized (this){
                //具体代码
            }*/
            //---------------------
            while (true) {
                boolean flag = sale();
                if (!flag){
                    break;
                }
            }
        }
        public synchronized boolean sale(){
            //锁对象是this：方法内部，操作this是谁，锁对象就是谁。如果上面新建线程放入不同的任务对象，则非同步10张票的售卖
            //如果static修饰，锁对象是类名.class
            if (count > 0) {
                System.out.println("准备出票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println(Thread.currentThread().getName()+"出票成功，余票为：" + count);
                return true;
            }
            return false;
        }
    }
}
