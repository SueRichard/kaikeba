package com.hllg.chap4.section4;

import java.io.*;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  13:19
 */
public class PrintStreamAndBufferedReaderTest {
    public static void main(String[] args) throws IOException {
        //字符输出（打印流）
        //字节
//        PrintStream ps = new PrintStream("l://a.txt");
//        ps.println("哈哈哈哈哈");
//        ps.println("哈哈哈哈哈");
//        ps.println("哈哈哈哈哈");
        //字符，操作一样，区别就是，字符需要刷新管道
//        PrintWriter pw = new PrintWriter("l://a.txt");
//        pw.println("123");
//        pw.println("123");
//        pw.println("123");
//        pw.flush();
        //---------------------------
        //如果需要往某个位置输出字符的话，建议拿到字节流转换成打印流
        //字节流
//        FileOutputStream fos = new FileOutputStream("l://a.txt");
//        //转换成打印流
//        PrintWriter pw = new PrintWriter(fos);
//        pw.println("测试测试");
//        pw.flush();
        //------------------------
        //缓存读取流，将字符流转换成带有缓存，一次读取一行的缓存字符读取流
        FileReader fr = new FileReader("l://a.txt");
        BufferedReader br = new BufferedReader(fr);
        String text = br.readLine();
        System.out.println(text);
        text = br.readLine();
        System.out.println(text);
        text = br.readLine();
        System.out.println(text);
        text = br.readLine();
        System.out.println(text);
        text = br.readLine();
        System.out.println(text);
    }
}
