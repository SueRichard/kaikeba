package com.hllg.chap4.section3;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/04  Thu  23:12
 */
public class MapTest {
    /**
     * Map
     * HashMap/Hashtable/ConcurrentHashMap
     * TreeMap
     * LinkedHashMap
     * 上面的map和下面案列使用方式一样，可以将名称改为对应的map集合，其他不变，没有问题
     * 需要注意的就是：
     *      1.Hashtable与其他集合存储顺序不一致；
     *      2.使用TreeMap时，自定义数据对象，需要实现comparable接口
     *
     * @param args
     */
    public static void main(String[] args) {
        Hashtable<String, String> data = new Hashtable<>();
        data.put("k1", "hl");
        data.put("k2", "cc");
//        String value = data.get("k1");
//        System.out.println(value);
//        value = data.get("k2");
//        System.out.println(value);
        Set<String> key = data.keySet();
        for (String k : key) {
            System.out.println(k + "->" + data.get(k));
        }
        Collection<String> values = data.values();
        for (String v : values) {
            System.out.println(v);
        }
    }
}
