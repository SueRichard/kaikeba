package com.hllg.chap4.io;

import java.io.*;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  12:54
 */

public class TransformTest {
    public static void main(String[] args) throws IOException {
//        //转换流
//        //将字节流装饰为字符流，装饰者设计模式
//        FileInputStream fis = new FileInputStream("l:a.txt");
//        //将字节输入流转化为字符输入流
//        //参数1：要转换的字节流
//        //参数2：指定编码名称(该参数可以省略)
//        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
//        while (true){
//            int a = isr.read();
//            if (a == -1){
//                break;
//            }
//            System.out.println((char)a);
//        }
//        isr.close();
        //-----------------------------
        FileOutputStream fos = new FileOutputStream("l://a.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.append("写入一些东西");
        osw.flush();
        osw.close();
    }
}
