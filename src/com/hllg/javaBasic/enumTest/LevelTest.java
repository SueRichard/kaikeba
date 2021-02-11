package com.hllg.javaBasic.enumTest;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/10  Wed  15:10
 */
public class LevelTest {
    public static void main(String[] args) {
        System.out.println(Level.LOW.getLevelValue());
        System.out.println("--------------------------");
        //比较
        System.out.println(Level3.LOW.compareTo(Level3.LOW));
        System.out.println(Level3.LOW.compareTo(Level3.MEDIUM));
        System.out.println(Level3.LOW.compareTo(Level3.HIGH));
        System.out.println(Level3.HIGH.compareTo(Level3.LOW));
        System.out.println("---------------------------");
        //常用方式1
        System.out.println(Level2.MEDIUM.equals(Level2.MEDIUM));
        System.out.println(Level3.MEDIUM.name());
        //只有此方法可以重写，剩下都来自与Enum抽象类
        System.out.println(Level2.HIGH.toString());
        //序号，从0开始
        System.out.println(Level2.HIGH.ordinal());
        //两个参数，获取某个类的类型，获取里面名称指定的常量值
        Level2 x = Enum.valueOf(Level2.class, "MEDIUM");
        System.out.println(x.name());
        System.out.println("------------------------");
        Level3Implements.LOW.show();
        Level3Implements.MEDIUM.show();
        System.out.println("------------------------");



    }

    /**
     * 枚举常用方式2
     * @param l
     * @return void
     * @Description TODO
     * @Author HLLG
     * @Date 10/02/2021 15:36
     **/
    public static void hl(Level2 l) {
        switch (l) {
            case LOW:
                //对应处理
                break;
            case MEDIUM:
                //对应处理
                break;
            case HIGH:
                //对应处理
                break;
        }
    }
}
