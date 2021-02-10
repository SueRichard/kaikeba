package com.hllg.chap4.reflection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/10  Wed  18:45
 * 类加载器
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws IOException {
        //获取类加载器；类名.class.getClassLoader()
        ClassLoader c = ClassLoaderTest.class.getClassLoader();
        System.out.println(c);
        //相对于src的路径
        //InputStream is = ClassLoaderTest.class.getResourceAsStream("/com/hllg/chap4/reflection/config.txt");
        //路径：config.txt找到的是当前文件夹下的
        //路径：../../../../config.txt 跳出多少次取决于运行文件所在目录；
        //查找方式是：如果resource下有，那么用resource下的，如果没有就用src下的
        //务必看下源码。getResourceAsStream()和IO流的相对路径有区别
        InputStream is = ClassLoaderTest.class.getResourceAsStream("../../../../config.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String text = br.readLine();
        System.out.println(text);
        br.close();
    }
}
