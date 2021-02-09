package com.hllg.chap4.commonLibrary;

import java.util.Calendar;

/**
 * @author HLLG
 * @version 1.0
 * @create 30/01/2021  15:56
 */
public class CalendarTest {
    public static void main(String[] args) {
        //因为该类用数据存取，所以里面的常量可以换成对应的下标地址，不过不推荐，倡导见名知意
        //获取实例
        Calendar c = Calendar.getInstance();
        //get 获取指定内容
        int year = c.get(Calendar.YEAR);
        System.out.println(year);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        //set方法，设置某一个时间
        c.set(Calendar.YEAR, 2020);
        System.out.println(c.get(Calendar.YEAR));
        //注意：月份是从0开始，所以实际月份需要加1
        c.add(Calendar.MONTH,-1);
        //如果需要减，参数放负数
        System.out.println(c.get(Calendar.MONTH));
        //获取指定条件的最大值，最小值
        System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(c.getActualMinimum(Calendar.DAY_OF_MONTH));
    }
}
