package com.hllg.javaBasic.enumTest;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/10  Wed  13:55
 * before1.5 enum
 * 级别
 */
public class Level {
    //只能从内部定义常量
    public static final Level LOW = new Level(1);
    public static final Level MEDIUM = new Level(50);
    public static final Level HIGH = new Level(100);
    private int levelValue;

    public int getLevelValue() {
        return levelValue;
    }

    private Level(int levelValue) {
        this.levelValue = levelValue;
    }
}
