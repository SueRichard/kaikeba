package com.hllg.objectOriented.advanced;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/14  Sun  11:28
 */
public class MemberInnerClassTest {
    public static void main(String[] args) {
        MemberInnerClass m = new MemberInnerClass();
        m.setX(200);
        MemberInnerClass.Inner i = m.new Inner();
        i.say();
    }
}
