package com.hllg.javaBasic.io;

import java.io.File;
import java.io.IOException;

/**
 * 请勿直接操作！查看代码后再决定
 *
 * @author HLLG
 * @version 1.0
 * @create 01/02/2021  16:22
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File f = new File("l://1.txt");
        //创建新文件
        boolean flag = f.createNewFile();
        System.out.println(flag ? "success" : "failed");
        System.out.println(f.getAbsolutePath());
        //删除需谨慎
        //f.delete();
//        File f2= new File("l://hl");
//        f2.mkdir();
//        f2.delete();
        //File f3 = new File("l://hl/hh/hl");
//        f3.mkdirs();
//        File f4= new File(f3,"1.txt");
//        f4.createNewFile();
//        File f5 = new File("l:\\hl","1.txt");
//        f5.createNewFile();
        //为空才可以删文件夹
        //f3.delete();
        //路径分隔符  ;   ，推荐这个写法
        System.out.println(File.pathSeparator);
        //名称分隔符\
        System.out.println(File.separator);
        //rename
//        File f6 = new File("l:1.txt");
//        File f7 = new File("l:1.txt");
//        //将f6制定的文件移动到f7
//        f6.renameTo(f7);
        //----------------------
        //改变了
        //测试git版本的改动，测试用
    }
}
