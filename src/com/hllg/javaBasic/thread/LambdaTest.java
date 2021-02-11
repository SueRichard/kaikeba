package com.hllg.javaBasic.thread;

/**
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  15:33
 * lambda表达式
 * 函数式编程思想
 * 注意：
 * 接口只能有一个抽象方法，才能用lambda表达式，用函数代替实现方法来实现接口，
 */
public class LambdaTest {
    public static void main(String[] args) {
        print(new MyMath() {
            @Override
            public int sum(int x, int y) {
                return x + y;
            }
        }, 100, 200);
        //重写方法即可
        print((int x, int y) -> {
            return x + y;
        }, 100, 200);
    }

    static interface MyMath {
        int sum(int x, int y);
    }

    public static void print(MyMath m, int x, int y) {
        int sum = m.sum(x, y);
        System.out.println(sum);
    }
}
