package com.hllg.chap4.section5;

/**
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  16:13
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

    static class Food {
        private String name;
        private String taste;

        public void setNameAndTaste(String name, String taste) {
            this.name = name;
            try {
                //制造时间片隙
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.taste = taste;
        }

        public void take() {
            System.out.println("服务员端走的菜是：" + name + "，味道：" + taste);
        }
    }
}
