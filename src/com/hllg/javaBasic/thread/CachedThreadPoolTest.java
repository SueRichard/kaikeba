package com.hllg.javaBasic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  14:33
 * 缓存线程池（长度不限制）
 * 加入任务后执行流程：
 * 1.判断是否有空闲进程，有就使用
 * 2.没有就创建，然后放入池中使用
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) {
        //创建缓存线程池
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "这是一句话");
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "这是一句话");
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "这是一句话");
            }
        });
        //此处休眠，用来检验是否后面用了之前创建的线程池
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "这是一句话");
            }
        });
    }
}
