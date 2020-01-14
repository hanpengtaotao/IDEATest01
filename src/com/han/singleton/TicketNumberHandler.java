package com.han.singleton;

import java.util.concurrent.atomic.AtomicLong;

/** 封装票号生成父类代码，以后的单例模式都继承该类
 * @author HPT
 * @version 1.0
 * @package com.han.singleton
 * @date 2020/1/14 0014 9:39
 */
public class TicketNumberHandler {
    //记录下一个唯一号码
    //private long nextUniqueNumber=1;

    /**
     * 生成票号
     * @return 票号
     * @author hpt 2020-01-14 9:40
     */
    /*public synchronized long getTicketNumber()
    {
        return nextUniqueNumber++;
    }*/

    private AtomicLong nextUniqueNumber = new AtomicLong();

    public Long getTicketNumber() {
        return nextUniqueNumber.incrementAndGet();
    }
}
