package com.hllg.chap4.commonLibrary;

import java.util.Scanner;

/**
 * @author HLLG
 * @version 1.0
 * @create 27/01/2021  16:39
 */
public class StringCompress {
    public static void main(String[] args) {
        compress();
    }

    /**
     * 字符串压缩，同一个字母只显示第一个后面跟上出现次数。
     * 如果压缩后长度不小于原字符串，显示原字符串
     */
    public static void compress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String text = scanner.nextLine();
        //转换成数组好比较和计数
        char[] c = text.toCharArray();
        System.out.println("转换成数组长度：" + c.length);
        StringBuffer stringBuffer = new StringBuffer();
        int count = 0;
        //默认值为数组第一个
        char temp = c[0];
        for (int i = 1; i < c.length; i++) {
            if (temp == c[i]) {
                count++;
                if (i == c.length - 1) {
                    stringBuffer.append(temp);
                    //加一是因为本身要算
                    stringBuffer.append(count + 1);
                }
            } else {
                stringBuffer.append(temp);
                //加一是因为本身要算
                stringBuffer.append(count + 1);
                temp = c[i];
                count = 0;
            }
        }
        if (text.length() <= stringBuffer.length()) {
            System.out.println(text);
        } else {
            System.out.println(stringBuffer.toString());
        }
    }
}
