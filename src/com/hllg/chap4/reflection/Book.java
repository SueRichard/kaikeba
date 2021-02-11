package com.hllg.chap4.reflection;

import java.util.Arrays;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  10:40
 */
public class Book {
    private String name;
    private int num;
    public float price;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    private void setNum(int num) {
        this.num = num;
    }

    private Book(String name) {
        this.name = name;
        this.num = 100;
    }

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Book() {
    }
    private void say(int[] num, String text,float floatNum){
        System.out.println("这是用来测试多个参数的调用列表");
        System.out.println("数量："+ Arrays.toString(num) +"，文本是："+text+"，浮点："+floatNum);
    }
}
