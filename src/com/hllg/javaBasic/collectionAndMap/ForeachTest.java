package com.hllg.javaBasic.collectionAndMap;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  00:31
 */
public class ForeachTest {
    public static void main(String[] args) {
        //增强for循环，最早出现在c#中
        //只能用于迭代数组和集合（collection），内部使用迭代器做输出
        int[] arr = {1,2,3,4,5};
        for (int a: arr) {
            System.out.println(a);
        }
    }
}
