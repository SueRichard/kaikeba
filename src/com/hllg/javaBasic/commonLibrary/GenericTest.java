package com.hllg.javaBasic.commonLibrary;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/12  Fri  13:34
 * 泛型类
 * 泛型方法
 */
public class GenericTest<T, H, L> {
    private T name;
    private L info;
    private H hl;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public L getInfo() {
        return info;
    }

    public void setInfo(L info) {
        this.info = info;
    }

    public H getHl() {
        return hl;
    }

    public void setHl(H hl) {
        this.hl = hl;
    }

    /**
     * 返回N类型，打印P类型
     * @param p
     * @param n
     * @param <P>
     * @param <N>
     * @return
     */
    //权限修饰符  （static）（final） 泛型 方法返回类型 方法名 （参数类型 参数名）
    public final <P, N> N say(P p, N n) {
        System.out.println(p);
        return n;
    }


}
