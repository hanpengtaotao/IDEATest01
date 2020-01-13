package com.han.singleton;

/***
 * @desription: 饿汉式静态块单例模式
 * @author    : hpt
 * @date      : 2020/1/13 23:01
 */
public class HungrySingleton1 {
    private static final HungrySingleton1 hungrySingleton1;

    static {
        hungrySingleton1 = new HungrySingleton1();
    }

    private HungrySingleton1() {
    }

    public static HungrySingleton1 getInstance() {
        return hungrySingleton1;
    }
}
