package com.hllg.javaBasic.thread;

/**
 * 线程死锁案例
 * 避免方式：如果一个方法已经有锁了，就不要再调用其他可能产生锁的方法
 *
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  13:02
 */
public class ThreadDeadlockTest {
    public static void main(String[] args) {
        Culprit c = new Culprit();
        Police p = new Police();
        new MyThread(c, p).start();
        c.say(p);
    }

    static class MyThread extends Thread {
        private Culprit c;
        private Police p;

        public MyThread(Culprit c, Police p) {
            this.c = c;
            this.p = p;
        }

        @Override
        public void run() {
            p.say(c);
        }
    }

    static class Culprit {
        public synchronized void say(Police p) {
            System.out.println("罪犯：你放我，我放人质。");
            p.answer();
        }

        public synchronized void answer() {
            System.out.println("罪犯：我放人质");
        }
    }

    static class Police {
        public synchronized void say(Culprit c) {
            System.out.println("警察：你先放人，我再放你");
            c.answer();
        }

        public synchronized void answer() {
            System.out.println("警察：我放你");
        }
    }
}
