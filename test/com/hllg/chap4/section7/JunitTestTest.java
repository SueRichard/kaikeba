package com.hllg.chap4.section7;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/06  Sat  14:44
 */
public class JunitTestTest {
    //注解
    @Test
    public void say() {
        System.out.println("这是测试类的方法");
        new JunitTest().say();
    }

    @Test
    public void say2() {
        System.out.println("这个是抛出异常的测试方法，红色");
        new JunitTest().say2();
        throw new RuntimeException("主动抛出异常");
    }

    @Test
    public void sum() {
        int sum = new JunitTest().sum(100, 200);
        //断言，不通过是黄色
        Assert.assertEquals(100, sum);
    }

    @Test
    public void say3() {
       //什么都不写，就什么都没有
    }
}