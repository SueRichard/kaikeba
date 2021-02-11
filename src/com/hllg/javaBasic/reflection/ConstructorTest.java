package com.hllg.javaBasic.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  11:03
 */
public class ConstructorTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //加载类对象
        Class<Book> bookClass = (Class<Book>) Class.forName("com.hllg.javaBasic.reflection.Book");
        //获取无参构造方法
        Constructor<Book> bookConstructor = bookClass.getConstructor();
        //使用无参构造方法，创建对象
        Book b1 = bookConstructor.newInstance();
        System.out.println(b1);
        //找到包含String name 和 int num的构造方法；
        // 参数：可变参数或数组，两种写法都可
        //Constructor<Book> c2 = bookClass.getConstructor(String.class, int.class);
        Constructor<Book> c2 = bookClass.getConstructor(new Class[]{String.class, int.class});
        //创建对象，如果不传参数，代码不报错，但是拿不到结果，运行时会有非法参数异常
        Book b2 = c2.newInstance("hl的故事", 97);
        System.out.println(b2);
        //获取所有权限的单个构造方法
        Constructor<Book> c3 = bookClass.getDeclaredConstructor(String.class);
        //忽略权限检查，该构造方法是private修饰的
        c3.setAccessible(true);
        Book b3 = c3.newInstance("cc的故事");
        System.out.println(b3);
        //获取所有权限的全部构造方法，注意方法名最后的s
        Constructor<Book>[] allConstruct = (Constructor<Book>[]) bookClass.getDeclaredConstructors();
        for (Constructor<Book> b : allConstruct) {
            System.out.println(b);
        }
    }
}
