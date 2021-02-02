package com.hllg.chap4.section3;

import java.util.Vector;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  21:42
 */
public class VectorTest {
    public static void main(String[] args) {
        //增量如果不指定，就是双倍增加，剩下和arraylist大致一样
        Vector<String> vector = new Vector<>();
        vector.add("123");
        vector.add("456");
        System.out.println(vector.get(1));
        String text = vector.remove(1);
        System.out.println(text);
        //返回当前容量，非使用量
        System.out.println(vector.capacity());
    }
}
