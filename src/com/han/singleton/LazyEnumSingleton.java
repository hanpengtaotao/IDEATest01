package com.han.singleton;

import java.util.concurrent.atomic.AtomicLong;

/** 使用枚举类创建懒汉式单例模式
 * @author HPT
 * @version 1.0
 * @package com.han.singleton
 * @date 2020/1/14 0014 10:50
 */
public enum LazyEnumSingleton {
    INSTANCE;

    private AtomicLong nextUniqueNumber = new AtomicLong();

    public synchronized Long getTicketNumber() {
        return nextUniqueNumber.incrementAndGet();
    }

    public static LazyEnumSingleton getInstance() {
        return INSTANCE;
    }
}
