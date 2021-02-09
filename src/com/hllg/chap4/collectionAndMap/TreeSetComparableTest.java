package com.hllg.chap4.collectionAndMap;

import java.util.TreeSet;

/**
 * @author HLLG
 * @version 1.0
 * @create 04/02/2021  20:14
 */
public class TreeSetComparableTest {
    public static void main(String[] args) {
        //TreeSet自定义数据类型比较
        TreeSet<Person> data = new TreeSet<>();
        Person cc = new Person("陈璨", 24);
        Person hl = new Person("胡蕾", 23);
        //相同age和name存不下去，注意下面的compareTo方法的写法
        Person ll = new Person("陈璨", 24);
        Person l = new Person("陈璨", 25);
        data.add(cc);
        data.add(hl);
        data.add(ll);
        data.add(l);
        for (Person p : data) {
            System.out.println(p);
        }
    }

    /**
     * 注意实现带有泛型，该泛型取决于你想和什么数据比
     * 如果不实现该方法，添加会有类型转换异常
     */
    static class Person implements Comparable<Person> {
        private String name;
        private int age;

        @Override
        public int compareTo(Person o) {
            /**
             * this 与 o 进行比较
             * 返回的数据：
             *      负数：this 小于 o
             *      0：this 和 o 相等
             *      正数：this 大于 o
             *
             *      注意！如果比较相同就不存入数据了！
             */
            if (this.age > o.age && !this.name.equals(o.name)) {
                return 1;
            } else if (this.age == o.age || this.name.equals(o.name)) {
                return 0;
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
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

    }
}
