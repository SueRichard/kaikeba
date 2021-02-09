package com.hllg.chap4.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  14:55
 * 单线程线程池
 * 执行流程：
 * 1.判断线程池的那个线程是否空闲，空闲就使用
 * 2.不空闲就等待
 */
public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        //创建单线程池
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\thl");
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\thl");
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\thl");
            }
        });

    }
}
