package com.hllg.javaBasic.thread;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  14:56
 */
public class ImplementsRunnableTest {
    public static void main(String[] args) {
        /**
         * 通过继承Thread和实现Runnable区别：
         *      1.通过创建任务，然后给线程分配任务的方式来实现多线程，适合多线程执行相同的任务
         *      2.可以避免单继承带来的局限性
         *      3.任务与线程本身是分离的，提高程序健壮性
         *      4.线程池接受Runnable的任务，不接受Thread类型的进程
         *      5.Thread优点就是简单，可以用匿名内部类
         */
        //创建一个任务对象
        RunnableTest rt = new RunnableTest();
        //创建一个线程，并分配任务
        Thread t = new Thread(rt);
        //执行线程
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("这是主进程" + i);
        }
    }
}
