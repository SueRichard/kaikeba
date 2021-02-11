package com.hllg.javaBasic.annotationAndReflection;

import java.util.Objects;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  13:26
 * 自定义注解使用
 * 获取类、属性注解值，理解ORM的实现原理，不含创建数据库部分
 */
@TableAnnotation(tableName = "person")
public class Person {
    @ColumnAnnotation(columnName = "person_age", columnType = "int", columnLength = "3")
    private int age;
    @ColumnAnnotation(columnName = "person_name", columnType = "varchar", columnLength = "10")
    private String name;
    @ColumnAnnotation(columnName = "person_info", columnType = "varchar", columnLength = "1000")
    private String info;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(info, person.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, info);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Person(int age, String name, String info) {
        this.age = age;
        this.name = name;
        this.info = info;
    }

    public Person() {
    }
}
