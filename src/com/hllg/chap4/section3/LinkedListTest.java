package com.hllg.chap4.section3;

import java.util.LinkedList;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  21:49
 */
public class LinkedListTest {
    public static void main(String[] args) {
        //LinkedList：双向链表结构，增删快，查找慢
        //由于这种结构特性，我们可以模拟栈、单端队列，双端队列
        LinkedList<Integer> list = new LinkedList<>();
        //首部添加
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        //它在首部，往下压
        list.addFirst(4);
        //尾部取，也可以首部取
        System.out.println("得到的底部："+list.getLast());
        System.out.println("得到的顶部："+list.getFirst());
        Integer num = list.removeLast();
        System.out.println("移除的最后一个："+num);
        //压栈
        list.push(10);
        list.push(20);
        list.push(30);
        //弹栈
        Integer i = list.pop();
        System.out.println("栈顶元素为："+i);
    }
}
