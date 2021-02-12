package com.hllg.javaBasic.commonLibrary;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/12  Fri  14:12
 * 泛型接口
 */
public interface GenericInterfaceTest<T> {
    /**
     * 实现接口既可以指定泛型，也可以不指定
     *
     * @return
     */
    T getData();
}
