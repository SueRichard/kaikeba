package com.hllg.chap4.section4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  12:15
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        //相对路径
        FileReader fr = new FileReader("b.txt");
        //---------------------
//        int read = fr.read();
//        System.out.println((char)read);
//       read = fr.read();
//        System.out.println((char)read);
//         read = fr.read();
//        System.out.println((char)read);
//        fr.close();
        //-----------------------
//        while (true) {
//            int r = fr.read();
//            if (r == -1) {
//                break;
//            }
//            System.out.println((char) r);
//        }
//        fr.close();
        char[] chars = new char[100];
        //char数组默认值
        System.out.println(chars[0]);
        //char数组默认码
        System.out.println((int) chars[0]);
        System.out.println(chars.length);
        //只打印接受了多少
        int len = fr.read(chars);
        System.out.println(new String(chars, 0, len));
        fr.close();
    }
}
