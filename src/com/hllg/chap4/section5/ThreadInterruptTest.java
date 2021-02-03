package com.hllg.chap4.section5;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  17:25
 */
public class ThreadInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        //一个线程是一个独立的路径，他是否中断，应该由它自身来决定，因为可能涉及到资源的释放
        Thread t;
        t = new Thread(new MyRunnable(), "子线程");
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            Thread.sleep(1000);
        }
        //给线程t设置中断标记，在特殊情况会去检查标记位，然后抛出异常，给程序员处理
        t.interrupt();
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    //由于Runnable没有声明异常抛出，所以子就不能申明更大范围的异常抛出
                    Thread.sleep(1000);
                    //具体哪些情况触发以下异常，请点击源码
                } catch (InterruptedException e) {
                    //通过标记位进入此异常，是否死亡由下面代码决定，外部干涉完整执行流程不合理，即不用stop方法，且他已过时，
                    //e.printStackTrace();
                    //System.out.println("捕获到标记位，暂未进行处理");
                    System.out.println("捕获到标记位，进程自杀");
                    /**
                     * 这里放需要释放的资源
                     */
                    //run方法是线程的任务，方法执行完毕，这个任务执行完毕
                    return;
                }
            }
        }
    }
}
