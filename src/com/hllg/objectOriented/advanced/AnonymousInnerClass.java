package com.hllg.objectOriented.advanced;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/14  Sun  12:03
 * 匿名内部类
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        //右边是父接口或父类，表示的是创建一个Person接口的实现类并new了对象赋值给p
        Person p = new Person() {
            @Override
            public void say() {
                System.out.println("这是匿名内部类");
            }
        };
        hl(p);
    }

    /**
     * @param p 对应的接口的实现类
     * @return void
     * @Description 测试某个接口的方法，不知道具体实现类怎么写，可以写局部内部类，
     * 创建一个实现类来传参
     * @Author HLLG
     * @Date 14/02/2021 12:08
     **/
    public static void hl(Person p) {

    }
}
