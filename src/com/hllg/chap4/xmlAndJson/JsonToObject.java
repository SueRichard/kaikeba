package com.hllg.chap4.xmlAndJson;

import com.google.gson.Gson;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/09  Tue  16:57
 * Gson转对象
 */
public class JsonToObject {
    public static void main(String[] args) {
        Gson g = new Gson();
        //转换，注意两个参数，
        Person p = g.fromJson("{\"name\":\"hl\",\"age\":18,\"sex\":\"女\"}", Person.class);
        System.out.println(p.getName());
    }
}
