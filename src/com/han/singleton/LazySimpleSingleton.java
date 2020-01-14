package com.han.singleton;

/** 懒汉式简单单例模式（线程不安全）
 * @author HPT
 * @version 1.0
 * @package com.han.singleton
 * @date 2020/1/14 0014 8:48
 */
public class LazySimpleSingleton extends TicketNumberHandler {
    //构造函数私有化
    LazySimpleSingleton() {
    }

    //定义私有该类变量（不能使用final,相当于readonly只能在定义或者构造函数中初始化该参数）
    private static LazySimpleSingleton lazySimpleSingleton = null;

    //公开获取该类实例
    /*public static LazySimpleSingleton getInstance() {
        if (lazySimpleSingleton == null) {
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }*/

    /**
     * 线程安全的懒汉式单例模式，但是此时线程会堵塞效率不高
     * @return 懒汉式单例类实例
     * @author hpt 2020-01-14 9:20
     */
    /*public synchronized static LazySimpleSingleton getInstance() {
        if (lazySimpleSingleton == null) {
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }*/

    /**
     * 使用同步代码块实现懒加载单例模式(此时的线程也会堵塞)
     * @return 懒汉式单例类实例
     * @author hpt 2020-01-14 10:26
     */
    /*public static LazySimpleSingleton getInstance() {
        if (lazySimpleSingleton == null) {
            synchronized (LazySimpleSingleton.class) {
                lazySimpleSingleton = new LazySimpleSingleton();
            }
        }
        return lazySimpleSingleton;
    }*/

    /**
     * 使用双重检查锁方式实现懒汉式单例模式
     * @return 懒汉式单例类实例
     * @author hpt 2020-01-14 10:28
     */
    public static LazySimpleSingleton getInstance() {
        if (lazySimpleSingleton == null) {
            synchronized (LazySimpleSingleton.class) {
                if (lazySimpleSingleton == null) {
                    lazySimpleSingleton = new LazySimpleSingleton();
                    //1. 分配内存给这个对象
                    //2. 初始化对象
                    //3. 设置 lazy 指向刚分配的内存地址
                }
            }
        }
        return lazySimpleSingleton;
    }
}
