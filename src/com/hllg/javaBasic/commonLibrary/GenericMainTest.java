package com.hllg.javaBasic.commonLibrary;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/12  Fri  13:58
 */
public class GenericMainTest {
    public static void main(String[] args) {
        GenericTest<Integer, String, Double> g = new GenericTest<>();
        //参数直接传，基本数据类型自动装箱拆箱
        Float say = g.say(12, 32f);
        System.out.println(say);
        /**
         * 引用类型=对象 多态；无法对容器内容进行多态
         * 两边都是盘子，没有子父关系
         */
        Plate<? extends Fruit, ? extends Fruit2> p = new Plate<Apple, Apple2>();
    }

    interface Fruit {
    }

    interface Fruit2 {
    }

    class Apple implements Fruit {
    }

    class Apple2 implements Fruit2 {
    }

    static class Plate<T, V> {
        T data;
    }
}
