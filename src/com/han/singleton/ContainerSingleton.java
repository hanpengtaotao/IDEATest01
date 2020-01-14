package com.han.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 注册式单例：容器式单例模式实现（实例非常多便于管理，但是是非线程安全的）
 * @author HPT
 * @version 1.0
 * @package com.han.singleton
 * @date 2020/1/14 0014 15:57
 */
public class ContainerSingleton {
    private ContainerSingleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    //反射机制实现类的初始化
    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
}
