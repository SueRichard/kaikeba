package com.hllg.chap4.commonLibrary;

import java.util.Objects;

/**
 * @author HLLG
 * @version 1.0
 * @create 27/01/2021  20:26
 */
public class ObjectsTest {
    public static void main(String[] args) {
        //判断[fromIndex,size+fromIndex)?∈[0,length）
        //不是，抛出异常，是返回子范围的最小下标
        System.out.println(Objects.checkFromIndexSize(17,1,17));
        String text = null;
        Student s = new Student();
        System.out.println(Objects.equals(text,s));
        System.out.println(Objects.isNull(s));
        System.out.println(Objects.nonNull(text));
        System.out.println(Objects.toString(s));
        System.out.println(Objects.requireNonNull(text));
        System.out.println(Objects.requireNonNull(text,"需要非空"));
    }
}
