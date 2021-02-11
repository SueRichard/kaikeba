package com.hllg.javaBasic.xmlAndJson;

import com.alibaba.fastjson.JSON;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/09  Tue  17:20
 */
public class FastJsonToObject {
    public static void main(String[] args) {
        //  1. 转换 {"age":24,"name":"cc","sex":"女"}
        Person c = JSON.parseObject("{\"age\":24,\"name\":\"cc\",\"sex\":\"女\"}", Person.class);
        System.out.println(c.getName());
    }
}
