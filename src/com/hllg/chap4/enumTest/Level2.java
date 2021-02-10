package com.hllg.chap4.enumTest;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/10  Wed  15:14
 * jdk1.5之后的enum写法
 */
public enum Level2 {
    //创建level2的对象，小括号为构造器
    LOW(1), MEDIUM(50), HIGH(100);
    private int levelValue;

    private Level2(int levelValue) {
        this.levelValue = levelValue;
    }

    public int getLevelValue() {
        return levelValue;
    }
    //不要提供set方法
    /*public void setLevelValue(int levelValue) {
        this.levelValue = levelValue;
    }*/
}
