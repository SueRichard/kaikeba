package com.hllg.chap4.io;

import java.io.File;
import java.io.FileFilter;

/**
 * @author HLLG
 * @version 1.0
 * @create 01/02/2021  16:56
 */
public class FileFilterAnonymousInsideClass {
    public static void main(String[] args) {
        //指定初始路径
        File l = new File("l:\\");
        listFiles(l);
    }

    /**
     * 过滤器
     *
     * @param files
     */
    public static void listFiles(File files) {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".jpg") || pathname.isDirectory()) {
                    //返回true保留
                    return true;
                }
                //返回false过滤掉
                return false;
            }
        };
        File[] file = files.listFiles(fileFilter);
        //下面不做判断，抛出空指针异常
        if (file != null && file.length > 0) {
            for (File f : file) {
                if (f.isDirectory()) {
                    listFiles(f);
                } else {
                    System.out.println("找到了jpg，" + f.getAbsolutePath());
                }
            }
        }
    }
}
