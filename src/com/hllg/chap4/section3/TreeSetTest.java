package com.hllg.chap4.section3;

import java.util.TreeSet;

/**
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  20:14
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //TreeSet存入的数据有序，该有序指的是数据的顺序，不是存储的顺序，看下面的字母案例
        TreeSet<String> data = new TreeSet<>();
        data.add("C");
        data.add("B");
        data.add("D");
        data.add("A");
        for (String s : data) {
            System.out.println(s);
        }
        //---------------------
        //字符顺序；找某一个具体的符号
        System.out.println((char) 0);
    }
}
