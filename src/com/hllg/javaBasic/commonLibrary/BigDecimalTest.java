package com.hllg.javaBasic.commonLibrary;

import java.math.BigDecimal;

/**
 * @author HLLG
 * @version 1.0
 * @create 30/01/2021  13:14
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        //有的时候可能会出现精度问题
        System.out.println(0.1+0.2);
        BigDecimal b = new BigDecimal("0.1");
        BigDecimal b1 = new BigDecimal("0.1");
        //加法
        BigDecimal b2 = b.add(b1);
        //除法
        b.divide(b2);
        //乘法
        b.multiply(b2);
        //减法
        b.subtract(b2);
        //获取整型值，其他更改名字就可了。
        b.intValue();
        b.floatValue();
        System.out.println(b2);
    }
}
