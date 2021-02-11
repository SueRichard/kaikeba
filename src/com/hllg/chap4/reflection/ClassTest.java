package com.hllg.chap4.reflection;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  10:26
 * 3种类加载方式
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 第一种方式 通过包名.类名.class 加载类，如果运行程序和类在一个包下，可以只写类名，但情况很少，了解即可
//        Class<Book> c1 = com.hllg.chap4.reflection.Book.class;
//        System.out.println(c1);
//        // 2. 第二种方式 通过类的对象获取类的信息
//        Book b = new Book();
//        Class<Book> c2 = (Class<Book>) b.getClass();
//        System.out.println(c2);
//        System.out.println(c2 == c1);
        // 3. 第三种方式 类名称加载 可以在Book不存在时使用，只要后续运行的时候能找到这个类就可以，编译不报错，
        // 最常用方式之一；动态编程；Book存在运行时就不报错
        Class c3 = Class.forName("com.hllg.chap4.reflection.Book");
        System.out.println(c3);
        //System.out.println(c1 == c2 && c1 == c3);
    }

    /**
     * 类的加载
     * 之后常用方式
     *
     * @param className
     * @return java.lang.Class
     * @Author HLLG
     * @Date 11/02/2021 10:42
     **/
    public static Class getClass2(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
}
