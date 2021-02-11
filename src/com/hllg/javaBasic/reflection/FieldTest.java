package com.hllg.javaBasic.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  12:42
 * 属性的获取和赋值
 */
public class FieldTest {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("com.hllg.javaBasic.reflection.Book");
        Constructor ct = c.getConstructor();
        Object o = ct.newInstance();
        Field price = c.getField("price");
        price.set(o, 23.6f);
        //Field name = c.getField("name");//NoSuchFieldException
        Field name = c.getDeclaredField("name");//IllegalAccessException
        name.setAccessible(true);
        name.set(o, "hl的书");
        System.out.println(o);
    }
}
