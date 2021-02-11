package com.hllg.chap4.annotationAndReflection;

import java.lang.annotation.*;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/11  Thu  13:19
 * 表格名称
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableAnnotation {
    /**
     * 表名
     *
     * @return
     */
    String tableName();
}
