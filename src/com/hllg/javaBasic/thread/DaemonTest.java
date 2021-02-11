package com.hllg.javaBasic.thread;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  17:25
 */
public class DaemonTest {
    public static void main(String[] args) {
        //线程分类：守护线程和用户线程
        //用户线程：当一个进程不包含任何存活的用户线程时，进程结束
        //守护线程：守护用户线程的，当最后一个用户线程结束时，所有守护线程自动死亡
        //
        //daemon守护线程
        //
        Thread t;
        t = new Thread(new MyRunnable(), "子线程");
        //在启动之前设置为守护进程
        t.setDaemon(true);
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
