package com.hllg.objectOriented.advanced;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/14  Sun  12:03
 * 调用方法测试，参数要求一个接口，但是不知道实现类怎么写，就可以使用局部内部类
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        //1.8之前需要加final，后自动加
        int a = 10;
        /**
         * 原因：任何类都被单独编译成.class文件，而内部的变量是备份，
         * 为了保持内部备份和外部值相等，系统从规定上限制了这个值不能被更改
         */
        //报错，因为下面使用了a，所以只能为final类型
        //a = 29;
        class PersonImpl implements Person {

            @Override
            public void say() {
                System.out.println("Person接口实现类，重写say方法" + a);
            }
        }
        PersonImpl p = new PersonImpl();
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
