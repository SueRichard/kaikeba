package com.hllg.javaBasic.thread;

/**
 * 多线程通信问题，生产者和消费者问题
 *
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  16:13
 * 假设一个碟子，一个厨师，一个服务员，做完菜端出等碟子回来再继续做
 */
public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Food f = new Food();
        new Cook(f).start();
        new Waiter(f).start();
    }

    /**
     * 厨师
     */
    static class Cook extends Thread {
        private Food food;

        public Cook(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    food.setNameAndTaste("蛋炒饭", "咸辣味");
                } else {
                    food.setNameAndTaste("八宝粥", "甜味");
                }
            }
        }
    }

    /**
     * 服务员
     */
    static class Waiter extends Thread {
        private Food food;

        public Waiter(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    //和厨师的时间一样，避免还没做出来就跑完了即服务员循环结束
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                food.take();
            }
        }
    }

    /**
     * 菜
     */
    static class Food {
        private String name;
        private String taste;
        //追加一个标志位，true表示可以生产
        private boolean flag = true;

        /**
         * 对改方法追加同步，但却不能解决问题
         * 因为synchronized是非公平锁，当你厨师做完，并不一定能给到服务员线程，
         * 就导致厨师做了多个菜，但是没来得及端出，然后最后厨师先做完了，服务员在重复端厨师做的最后一个菜
         */
        public synchronized void setNameAndTaste(String name, String taste) {
            if (flag) {
                this.name = name;
                try {
                    //制造时间片隙
                    Thread.sleep(100);
                    //菜名改了，但是味道没有改，被服务员线程抢占了
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.taste = taste;
                //更改标志位，让服务员可以取
                flag = false;
                //唤醒其他线程，该方法来源于Object
                this.notifyAll();
                try {
                    //自己等待
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void take() {
            if (!flag) {
                System.out.println("服务员端走的菜是：" + name + "，味道：" + taste);
                //更改标志位，让厨师做
                flag = true;
                //通知其他所有该对象下的线程
                this.notifyAll();
                try {
                    //阻塞自己
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
