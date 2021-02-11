package com.hllg.javaBasic.xmlAndJson;

import com.alibaba.fastjson.JSON;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/09  Tue  17:18
 */
public class FastJsonToString {
    public static void main(String[] args) {
        Person p = new Person("cc",24,'女');
        String person = JSON.toJSONString(p);
        System.out.println(person);
    }
}
