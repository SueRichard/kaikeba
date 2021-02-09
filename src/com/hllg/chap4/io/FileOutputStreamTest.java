package com.hllg.chap4.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @create 01/02/2021  19:38
 */
public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        //表示不追加，清空再写，默认是这个，其他输出流差不多，写入方式就那三种，记得关闭流管道
        FileOutputStream fos = new FileOutputStream("l:\\a.txt");
        //表示追加，不删除之前的，接着写
        FileOutputStream fos1 = new FileOutputStream("l:\\a.txt",true);
        //写入方式一：int值 低8位有效
        fos.write(65);
        //写入方式二：byte数组
        byte[] bytes = {65,66,67};
        fos.write(bytes);
        //写入方式三：数组，起始位，写入长度
        byte[] bytes1 = "hl should i ".getBytes();//获取字符串的数组
        fos.write(bytes1, 1, 4);
        //写完关闭
        fos.close();
        System.out.println("已写出");
    }
}
