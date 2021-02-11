package com.hllg.javaBasic.annotationAndReflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  13:34
 * 获取Person类的注解内容
 */
public class GetAnnotationInfoByScan {
    public static void main(String[] args) throws Exception {
        System.out.println("----------获取类注解，但是值并不是我想要的--------");
        Class pClass = Class.forName("com.hllg.javaBasic.annotationAndReflection.Person");
        Annotation a = pClass.getAnnotation(TableAnnotation.class);
        System.out.println(a);
        //或者，不过就一个遍历无意义
        Annotation[] annotations = pClass.getAnnotations();
        for (Annotation as : annotations) {
            System.out.println(as);
        }
        System.out.println("------------------------------------------");
        TableAnnotation ta = (TableAnnotation) pClass.getAnnotation(TableAnnotation.class);
        String tableName = ta.tableName();
        System.out.println("类名：" + pClass.getName() + "，表名为：" + tableName);
        //拿字段，注意是所有字段！
        Field[] fields = pClass.getDeclaredFields();
        for (Field f : fields) {
            //取出每一个属性的注解的参数值
            ColumnAnnotation ca = f.getAnnotation(ColumnAnnotation.class);
            System.out.println(f.getName() + "属性，对应数据库中的" + ca.columnName() + "字段，属性类型" + f.getType() + "，对应数据类型：" + ca.columnType() + "，数据长度：" + ca.columnLength());
        }
    }
}
