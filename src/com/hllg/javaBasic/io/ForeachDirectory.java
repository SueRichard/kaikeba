package com.hllg.javaBasic.io;

import java.io.File;

/**
 * @author HLLG
 * @version 1.0
 * @create 01/02/2021  16:56
 */
public class ForeachDirectory {
    public static void main(String[] args) {
        //指定初始路径
        File f = new File("l:\\");
        //获取所有文件存入数组
        File[] files = f.listFiles();
        listFiles(files);
    }

    /**
     * 遍历文件夹
     *
     * @param files
     */
    public static void listFiles(File[] files) {
        //不为空且长度不为0
        if (files != null && files.length > 0) {
            for (File f : files) {
                //判断是文件
                if (f.isFile()) {
                    //指定搜索文件类型
                    if (f.getName().endsWith(".jpg")) {
                        //指定文件大小，单位字节，这里是2M
                        if (f.length() > 2 * 1024 * 1024) {
                            //打印文件路径
                            //这里可以加delete()，类似于删除垃圾文件，慎用
                            //f.delete();
                            System.out.println(f.getAbsolutePath());
                        }
                    }
                } else {
                    //文件夹
                    File[] directory = f.listFiles();
                    listFiles(directory);
                }
            }
        }
    }
}
