package com.hllg.chap4.collectionAndMap;

import java.util.Set;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  00:37
 */
public class SetTest {
    public static void main(String[] args) {
        //继承自collection，和其方法基本一致，扩展不多
        //没有get方法，要想获取下标，2种方式：iterator/toArray方法
        //不包含重复元素，包括null值，类似于数学中的集
        //如果将可变对象用作set元素，要小心，（可变对象：存入后修改的对象），
        //set子类存储时无序
        //set的一些子类依据对象属性算出存储位置，修改后，找不到。即数据结构不同算出不同位置。
        Set s;
    }
}
