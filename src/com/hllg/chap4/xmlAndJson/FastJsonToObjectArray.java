package com.hllg.chap4.xmlAndJson;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/09  Tue  17:20
 */
public class FastJsonToObjectArray {
    public static void main(String[] args) {
        //  1. 转换 ["hl","cc","hh"]
        List<String> strings = JSON.parseArray("[\"hl\",\"cc\",\"hh\"]", String.class);
        System.out.println(strings.get(0));
    }
}
