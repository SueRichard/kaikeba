package com.hllg.chap4.xmlAndJson;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/09  Tue  16:57
 * Gson转对象，其中json里面包含数组
 */
public class JsonToObjectIncludeList {
    public static void main(String[] args) {
        Gson g = new Gson();
        //转换{"name":"hl","age":18,"sex":"女","w":["hl1","hl2","hl3"]}
        HashMap data = g.fromJson("{\"name\":\"hl\",\"age\":18,\"sex\":\"女\",\"w\":[\"hl1\",\"hl2\",\"hl3\"]}", HashMap.class);
        System.out.println(data.get("w"));
        //ArrayList，对象里面有数据，他就会转换成ArrayList(List)
        System.out.println(data.get("w").getClass());
        List list = (List) data.get("w");
        System.out.println(list.get(1));
    }
}
