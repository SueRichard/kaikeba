package com.hllg.chap4.commonLibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HLLG
 * @version 1.0
 * @create 29/01/2021  13:54
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        long a = System.currentTimeMillis();
        Date date = new Date(a);
        //System.out.println(date.getYear()+1900);
        //date.getTime();
        System.out.println(date.toString());
        //指定格式
        SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //date转化成字符串
        System.out.println(s.format(new Date()));
        //字符串转化成date
        Date d = s.parse("1997年9月16日 00:00:00");
        System.out.println((new Date().getTime()-d.getTime())/1000/60/60/24);
    }
}
