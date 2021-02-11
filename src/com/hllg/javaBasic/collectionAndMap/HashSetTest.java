package com.hllg.javaBasic.collectionAndMap;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author HLLG
 * @version 1.0
 * @create 03/02/2021  00:48
 */
public class HashSetTest {
    public static void main(String[] args) {
        //HashSet：散列存放 (哈希表实现) 用HashMap实现的
        HashSet<String> set = new HashSet<>();
        //无序集合，不保证读取和写入顺序一致
        set.add("你好");
        set.add("测试");
        set.add("hl");
        boolean flag1 = set.add("cc");
        //尝试追加相同的值
        boolean flag2 = set.add("cc");
        System.out.println(flag1);
        //打印添加结果
        System.out.println(flag2);
        //遍历方式1：
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //遍历方式2：
        //效率和iterator的效率一样
        for (String s : set) {
            System.out.println(s);
        }
    }
}
