package com.hllg.chap4.io;

import java.io.*;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  14:34
 */
public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        //序列化
//        //存入什么，取出的就是什么！
//        Person p =new Person("黄浩",18);
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("l://a.txt"));
//        oos.writeObject(p);//除了writeObject方法外还有写入UTF的字符创，writeXXX，其中XXX为基本数据类型
//        oos.close();
        //--------------------
       //反序列化

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("l://a.txt"));
        //Object o = ois.readObject();//扔出ClassNotFoundException 如果没有找到对应的类的话。
        Person p = (Person) ois.readObject();
        System.out.println(p.getName());
    }
    //实现serializable 即标记，才可以被序列化
    static class Person implements Serializable {
        //如果此类有其他引用类型属性，则该属性也需做标记，然后此类才可以完成序列化
        private String name;//string 有完成序列化，常见的也都有
        private int age;

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
