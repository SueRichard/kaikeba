package com.hllg.mysqlBasic.jdbc.aircraft;

import java.text.DecimalFormat;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/20  Sat  14:54
 */
public class DecimalFormatTest {
    public static void main(String[] args) {
        int i = 1;
        System.out.println(new DecimalFormat("000").format(i));
        String s = Integer.toString(i);
        String s1 = String.valueOf(i);
        String s2 = i + "";
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        float x = 874000.7682f;
        System.out.println(decimalFormat.format(x));
    }
}
