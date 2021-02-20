package com.hllg.objectOriented.advanced;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/14  Sun  11:28
 * 一个内部类
 */
public class MemberInnerClass {
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     * 一个成员内部类
     *
     * @param null
     * @return
     * @Author HLLG
     * @Date 14/02/2021 11:48
     **/
    class Inner {
        private int x = 100;

        public void say() {
            //隐藏现象，同名变量。会优先使用内部类的x
            System.out.println("这是内部类的x，值为：" + x);
            System.out.println("这是外部类的x，值为：" + MemberInnerClass.this.x);
        }
    }
}
