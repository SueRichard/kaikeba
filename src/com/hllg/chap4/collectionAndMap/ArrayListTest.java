package com.hllg.chap4.collectionAndMap;

import java.util.ArrayList;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  19:43
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //arraylist是数组结构，增删慢，查找快
        //如果存储初始的容量比较大，建议指定大小，否则频繁扩容，浪费资源，扩容大小为原来的1.5倍
        //默认大小为10，但是刚创建长度0
        ArrayList<Integer> list = new ArrayList<>();
        //返回永远为true
        //只有第一次添加，才会把长度设为10
        list.add(1);
        list.add(0, 10);
        System.out.println(list.get(0));
    }
}
