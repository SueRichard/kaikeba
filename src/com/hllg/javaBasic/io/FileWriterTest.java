package com.hllg.javaBasic.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  11:31
 */
public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        //来源于Writer
        FileWriter fw = new FileWriter("l:\\a.txt", true);
        //fw.write("胡蕾啊，胡蕾。");
        fw.write('l');
        //1.append方法返回当前调用对象
        FileWriter fw2 = (FileWriter) fw.append("test");//多态，强转
        System.out.println(fw2 == fw);
        //2.append方法源码依旧是write方法，可以点进去看看
        fw.append("hahah").append("hhhhh").append("hlhlhl");
        //强制缓冲写出，在循环中，每次写完都需要将其写出；
        //当调用close方法时，它会调用一次flush，所以之前没有使用，也没有问题
        fw.flush();
        fw.close();
    }
}
