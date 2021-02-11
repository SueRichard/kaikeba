package com.hllg.chap4.introspector;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  14:19
 */
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -7540183971360368641L;
    private String name;
    private int age;
    private char sex;
    private String info;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", info='" + info + '\'' +
                ", flag=" + flag +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Person() {
    }
}
