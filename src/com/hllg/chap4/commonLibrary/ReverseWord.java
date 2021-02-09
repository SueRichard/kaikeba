package com.hllg.chap4.commonLibrary;

import java.util.Scanner;

/**
 * @author HLLG
 * @version 1.0
 * @create 27/01/2021  15:38
 */
public class ReverseWord {
    public static void main(String[] args) {
        ReverseWord r = new ReverseWord();
        r.reverse();
    }

    /**
     * 逆转输入的每个单词
     */
    public void reverse(){
        StringBuffer stringBuffer = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一段文本");
        String text = sc.nextLine();
        String[] temp = text.split(" ");
        for (int i = 0; i < temp.length; i++) {
            StringBuffer s = new StringBuffer(temp[i]);
            stringBuffer.append(s.reverse());
            stringBuffer.append(" ");
        }
        System.out.println(stringBuffer.toString());
    }
}
