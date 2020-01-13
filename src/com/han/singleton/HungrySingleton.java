package com.han.singleton;

/***
 * @desription: 饿汉式单例模式
 * @author    : hpt
 * @date      : 2020/1/13 22:57
 */
public class HungrySingleton {
    /*
    先静态，后动态
    先属性，后方法
    先上后下
     */
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
