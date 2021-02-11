package com.hllg.javaBasic.annotation;

import java.lang.annotation.*;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/10  Wed  17:49
 */
//使用默认值
@MyAnnotation
public class MyAnnotationTest {
    public static void main(String[] args) {

    }

    //每一个注解都是接口实现类对象
    //默认的value可以不指定参数名，多个参数需要写出参数名称
    //@MyAnnotation("hl")
    //@MyAnnotation(value = "hl",num=1)
    @MyAnnotation({"hl", "hh"})
    public void say() {
    }
}

//注解是否包含在文档中
@Documented
//用途类型
@Target({ElementType.TYPE, ElementType.METHOD})
//保存策略
@Retention(RetentionPolicy.RUNTIME)
//可以继承
@Inherited
@interface MyAnnotation {
    String[] value() default "hl";

    //没有默认值都要传
    int num() default 18;
}

