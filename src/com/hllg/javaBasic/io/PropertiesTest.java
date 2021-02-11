package com.hllg.javaBasic.io;

import java.io.*;
import java.util.Properties;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  14:00
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        //properties文件和properties类，继承hashtable，实现map
//        Properties p = new Properties();
//        p.put("name","hl");
//        p.put("role","w");
//        Writer w = new FileWriter("l://people.properties");
//        //存储
//        p.store(w,"这是注释");
//        w.close();
        Properties p = new Properties();
        Reader r =new FileReader("l://people.properties");
        p.load(r);
        //返回类型为String
        System.out.println(p.getProperty("name"));
        //返回类型为object
        System.out.println(p.get("role"));
    }
}
