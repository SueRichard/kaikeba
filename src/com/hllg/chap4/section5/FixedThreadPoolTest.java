package com.hllg.chap4.section5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  14:43
 * 定长线程池（长度为指定值）
 * 加入任务后执行流程：
 *      1.判断是否存在空闲线程，有就使用；
 *      2.不存在空闲线程，看是否满了，不满就创建，放入线程池，然后使用，满了等待空闲线程
 */
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        //创建定长线程池
        ExecutorService services = Executors.newFixedThreadPool(2);
        services.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "hl");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        services.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "hl");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        services.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "hl");
            }
        });
    }
}
