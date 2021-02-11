package com.hllg.javaBasic.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  15:06
 *
 * 周期任务 定长线程池
 *          和定长线程池流程一致
 * 周期性任务执行：
 *          定时执行，当某个时机触发，自动执行
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        /**
         * 1.定时执行一次
         * 参数1：执行的任务
         * 参数2：时长数字
         * 参数3：时长数字的时间单位，由TimeUnit的常量指定
         */
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("打印");
            }
        },5, TimeUnit.SECONDS);
        /**
         * 2. 周期性执行任务
         * 参数1：执行任务
         * 参数2：延迟时长数字（第一次执行在什么时间以后）
         * 参数3：周期时长数字（每隔多久执行一次）
         * 参数4：时长数字的时间单位
         */
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("hl，你好");
            }
        },2,1,TimeUnit.SECONDS);
    }
}
