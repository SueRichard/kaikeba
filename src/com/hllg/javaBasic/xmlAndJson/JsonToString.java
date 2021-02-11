package com.hllg.javaBasic.xmlAndJson;

import com.google.gson.Gson;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/09  Tue  16:52
 * Gson对象转JSON字符串
 */
public class JsonToString {
    public static void main(String[] args) {
        //新建对象，只使用一次，用匿名对象
        Gson g = new Gson();
        Person p = new Person("hl", 18, '女');
        //转换
        String person = g.toJson(p);
        System.out.println(person);
    }
}
