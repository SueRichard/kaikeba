package com.hllg.chap4.commonLibrary;

/**
 * @author HLLG
 * @version 1.0
 * @create 27/01/2021  21:21
 */
public class MathTest {
    public static void main(String[] args) {
        short s = -12;
        System.out.println(Math.abs(s));
        int a = (int) Math.floor(3.4);
        System.out.println(Math.floor(a));
        System.out.println(Math.log1p(Math.E - 1));
        System.out.println(Math.pow(10, 2));
        System.out.println(Math.rint(3.5));
        System.out.println(Math.signum(5));
        System.out.println(Math.ulp(10));
        System.out.println(Math.toDegrees(Math.PI/2));
        System.out.println(Math.toRadians(180));
    }
}
