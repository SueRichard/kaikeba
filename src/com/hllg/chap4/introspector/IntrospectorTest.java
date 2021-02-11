package com.hllg.chap4.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  14:17
 * 内省
 * 获取bean所有的get/set方法
 * 注意boolean类型get方法是is开头
 * 注意的bean的规范,如果bean不提供get/set方法内省无法获取
 */
public class IntrospectorTest {
    public static void main(String[] args) throws IntrospectionException {
        //类
        Class c = Person.class;
        BeanInfo bi = Introspector.getBeanInfo(c);
        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
        System.out.println("----------开始遍历get/set方法-------------");
        for (PropertyDescriptor pd : pds) {
            //获取set、get方法
            Method get = pd.getReadMethod();
            Method set = pd.getWriteMethod();
            System.out.println(get);
            System.out.println(set);
            //属性名称
            System.out.println(pd.getName());
            //属性类型
            System.out.println(pd.getPropertyType());
            //获取属性值，需要有对象才可以使用
            //System.out.println(pd.getValue("sex"));
            System.out.println("----------------------------");
        }
    }
}
