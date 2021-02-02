package com.hllg.chap4.section3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  23:56
 */
public class IteratorAndListIteratorTest {
    public static void main(String[] args) {
        //迭代器用于遍历集合，共2中
        //1.Iterator，用于遍历collection下的所有集合
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            //只有向下移动才可以遍历，否则指针探测完回到原地，下方返回值是Integer
//            Integer i = iterator.next();
//            System.out.println(i);
//        }
        //初始位置在下标0上，所以无法删除，只有向下一步才可以删除
//        iterator.next();
//        iterator.remove();
//        System.out.println(list.size());
        //----------------------------
        //2.ListIterator，用于遍历list下的所有集合
        //以下的之前操作只有ListIterator才有
        ListIterator<Integer> iterator = list.listIterator();
        //头部没有上一个元素，异常
        //iterator.previous();
        //添加在当前指针之前
        iterator.add(97);
        iterator.next();
        iterator.next();
        //更改指向的元素，此时为集合中的第二个
        iterator.set(9);
        //一开始添加一个，所以向上移动三步
        iterator.previous();
        iterator.previous();
        iterator.previous();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
