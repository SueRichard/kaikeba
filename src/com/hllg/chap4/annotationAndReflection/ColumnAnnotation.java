package com.hllg.chap4.annotationAndReflection;

import java.lang.annotation.*;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  13:21
 * 列名称，类型，长度
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColumnAnnotation {
    /**
     * 字段名
     *
     * @return
     */
    String columnName();

    /**
     * 字段类型
     *
     * @return
     */
    String columnType();

    /**
     * 字段长度
     *
     * @return
     */
    String columnLength();
}
