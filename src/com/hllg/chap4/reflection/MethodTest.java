package com.hllg.chap4.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  12:09
 * 获取单个/所有方法，以及忽略权限修饰
 * 面向未来编程，运行时有该类就可以
 */
public class MethodTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //加载类，此处没有加泛型，后面处理即可
        Class bClass = Class.forName("com.hllg.chap4.reflection.Book");
        //获取无参构造器
        Constructor c1 = bClass.getConstructor();
        //创建对象
        Object o = c1.newInstance();
        /**
         * 参数1：指定方法名称
         * 参数2：可变参数，描述方法所需要的类型列表
         */
        Method setName = bClass.getMethod("setName", String.class);
        //获取所有方法，和类的加载类似
        Method setNum = bClass.getDeclaredMethod("setNum", int.class);
        //忽略权限
        setNum.setAccessible(true);
        //测试多个参数的类型列表
        Method say = bClass.getDeclaredMethod("say", int[].class, String.class, float.class);
        say.setAccessible(true);
        say.invoke(o,new int[]{97,9,16},"hl是我的",2.3f);
        /**
         * invoke（参数1，参数2）
         * 参数1：调用哪个对象执行setName方法
         * 参数2：可变参数，调用方法时传入的参数0~n个
         */
        setName.invoke(o, "hl的故事");
        setNum.invoke(o, 916);
        System.out.println(o);
    }
}
