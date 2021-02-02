package com.hllg.chap4.section2;

import java.util.Arrays;

/**
 * @author HLLG
 * @version 1.0
 * @create 29/01/2021  13:00
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] arr ={3,8,2,5,7,1};
        Arrays.sort(arr);
        System.out.println(Arrays.binarySearch(arr, 2));
        System.out.println(Arrays.binarySearch(arr, 1, 2,9));
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        arr = Arrays.copyOf(arr, 10);
        System.out.println(arr.length);
    }
}
