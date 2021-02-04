package com.hllg.chap4.section5;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 运行前，请看代码。
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  15:50
 * 线程的第三种创建方式
 * 之前的两种创建方式，都是并发的，而Callable则有主次关系，即主线程等子线程的执行结果
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> c = new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(c);
        new Thread(task).start();
        //get方法获取结果值，主线程在这里会等待task的结果，再往下运行
        Integer result = task.get();
        //还有2个方法
        //是否任务完成，返回布尔
        task.isDone();
        //是否取消任务，返回布尔，参数true为取消
        //返回结果为true，表示取消了该进程任务，为false大多情况时任务已经完成了
        task.cancel(true);
        System.out.println("task结果：" + result);
        for (int i = 0; i < 10; i++) {
            try {
                //加休眠的目的是，一个时间片内打印10次可以做完，看不到交叉打印结果
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    /**
     * 注意下面实现的接口的 泛型
     */
    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println(i);
            }
            return 100;
        }
    }
}
