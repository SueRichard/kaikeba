package com.hllg.chap4.xmlAndJson;

import com.thoughtworks.xstream.XStream;

import java.util.Objects;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/09  Tue  14:13
 * 当我们希望用对象的数据创建xml借助XStream
 * get麻烦
 */
public class GenerateXMLByXStream {
    public static void main(String[] args) {
        Person hl = new Person("hl", 18, "喜欢你");
        //XStream的使用
        //  1. 创建XStream的对象
        XStream x = new XStream();
        //  2. 修改某个类型生成的节点名称（可选设置；默认是包名.类名）
        x.alias("hl", Person.class);
        //  3. 传入对象开始生成
        String xml = x.toXML(hl);
        System.out.println(xml);
    }

    static class Person {
        private String name;
        private int age;
        private String say;

        public Person(String name, int age, String say) {
            this.name = name;
            this.age = age;
            this.say = say;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name) && Objects.equals(say, person.say);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, say);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", say='" + say + '\'' +
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

        public String getSay() {
            return say;
        }

        public void setSay(String say) {
            this.say = say;
        }
    }
}
