package com.hllg.chap4.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @create 01/02/2021  20:09
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("l:\\a.txt");
        //实际上读取到的是byte，可以强转
//        byte a = (byte) fis.read();
//        byte b = (byte) fis.read();
//        fis.close();
//        //打印ASCII码
//        System.out.println(a);
//        //打印字符
//        System.out.println((char) b);
        //------------------------------
//        while (true) {
//            byte b1 = (byte) fis.read();
//            if (b1 == -1){
//                break;
//            }
//            System.out.println((char) b1);
//            //-1表明没有东西可以读了
//            //System.out.println(b1);
//        }
//        fis.close();
        //------------------------
        //打印有问题，最后一行，因为旧数组有没有被覆盖的
//        byte[] b2 = new byte[10];
//        fis.read(b2);
//        //字节数组转换为字符串
//        System.out.println(new String(b2));
//        fis.read(b2);
//        System.out.println(new String(b2));
//        fis.read(b2);
//        System.out.println(new String(b2));
//        fis.close();
        //------------------------
        //处理：用读取到的有效字节个数控制显示    len控制
        byte[] b2 = new byte[100];
        int len = fis.read(b2);//10
        //字节数组转换为字符串
        System.out.println(new String(b2, 0, len));
        len = fis.read(b2);//10
        System.out.println(new String(b2, 0, len));
        len = fis.read(b2);//6
        System.out.println(new String(b2, 0, len));
        fis.close();
    }
}
