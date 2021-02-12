package com.hllg.javaBasic.commonLibrary;

import java.util.Locale;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  19:04
 * 关于String类的常用方法
 */
public class StringTest {
    public static void main(String[] args) {
        //两个相同字符串，变量名不同
        //永久代，
        String text1 = "hlahh";
        //先去永久代找，有就不再创建，直接复制内存地址
        String text2 = "hlahh";
        //true 指向同一块内存地址
        System.out.println(text1 == text2);
        //new对象肯定不一致，两对象
        String text3 = new String("hlahh");
        System.out.println(text1 == text3);
        //子串，左闭右开
        System.out.println("hhhl".substring(1, 3));
        System.out.println("------------------------------");
        System.out.println(text3.codePointAt(2));
        String hl = "hl";
        System.out.println("开头" + hl.startsWith("l", 1));
        String replace = hl.replace('h', 'l');
        System.out.println(replace);
        //重复count次
        System.out.println(hl.repeat(5));
        //转换大写
        System.out.println(text2.toUpperCase(Locale.ROOT));
        System.out.println(text2.toUpperCase());
        StringBuffer s = new StringBuffer();
        System.out.println("--------insert----------");
        CharSequence c = "hlahhh";
        StringBuilder sb = new StringBuilder("今天天气好好");
        StringBuilder insert = sb.insert(1, c, 1, 2);
        System.out.println(insert);
    }
}
