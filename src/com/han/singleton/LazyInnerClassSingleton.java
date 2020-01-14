package com.han.singleton;

/** 使用静态内部类的方式实现单例模式的加载
 * @author HPT
 * @version 1.0
 * @package com.han.singleton
 * @date 2020/1/14 0014 10:40
 */
public class LazyInnerClassSingleton extends TicketNumberHandler {
    //私有化构造函数
    //使用 LazyInnerClassSingleton的时候，默认会先初始化内部类
    //如果没使用，则内部类是不加载的
    private LazyInnerClassSingleton() {
        if (LazyInnerClass.LAZY != null) {  //防止反射模式创建类实例
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    //获取实例化类，static 是为了使单例的空间共事 ， final保证这个方法不会被重写、重载
    public static final LazyInnerClassSingleton getInstance() {
        //在返回结果以前，一定会先加载内部类
        return LazyInnerClass.LAZY;
    }

    //定义静态内部类，默认不加载
    private static class LazyInnerClass {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

    //防止序列化反序列化出现破坏单例
    private Object readResolve() {
        return  LazyInnerClass.LAZY;
    }
}
