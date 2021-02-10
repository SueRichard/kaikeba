package com.hllg.chap4.enumTest;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/10  Wed  15:22
 * 由于java单继承，所有使用接口
 * 接口实现枚举的每个常量调用不同方法
 */
public enum Level3Implements implements LevelShow {
    //想让每个对象拥有不用的方法
    LOW() {
        @Override
        public void show() {
            System.out.println("这是低级别");
        }
    }, MEDIUM {
        @Override
        public void show() {
            System.out.println("这是中级别");
        }
    }, HIGH {
        @Override
        public void show() {
            System.out.println("这是高级别");
        }
    }
}

//所有对象都是同一个方法
 /*   @Override
    public void show() {
        System.out.println("级别对象调用show方法");
    }
}*/
interface LevelShow {
    void show();
}
