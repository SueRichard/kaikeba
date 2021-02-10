package com.hllg.chap4.annotation;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/10  Wed  16:51
 */
public class AnnotationTest {
    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        //抑制所有警告，可以放在任意位置，比如方法，类，变量
        @SuppressWarnings("all")
        Person p = new Person();
        //有删除线
        p.setAge(10);
    }
}

class Person {
    private int age;

    public int getAge() {
        return age;
    }

    /**
     * 此方法已被弃用，请使用setAgeAndCheck
     * 下面一行内容不显示，提示程序员用
     * @Description TODO
     * @param age
     * @return void
     * @Author HLLG
     * @Date 10/02/2021 16:57
     **/
    @Deprecated
    public void setAge(int age) {
        this.age = age;
    }

    public void setAgeAndCheck(int age) {
        if (age < 0 || age > 120) {
            throw new RuntimeException("年龄不合理");
        } else {
            this.age = age;
        }

    }
}
