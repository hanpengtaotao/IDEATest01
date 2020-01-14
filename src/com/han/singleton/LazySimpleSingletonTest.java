package com.han.singleton;

import java.util.*;

/**
 * @author HPT
 * @version 1.0
 * @package com.han.singleton
 * @date 2020/1/14 0014 9:13
 */
public class LazySimpleSingletonTest {
    public static void main(String[] args) throws InterruptedException {
        int userCount = 20000;  //用户人数
        Set<Thread> threadSet = new HashSet();  //保存用户线程

        //List<TicketNumberHandler> handlerList = new Vector(); //用于存放TicketNumberHandler实例对象
        List<LazyEnumSingleton> handlerList = new Vector(); //用于存放TicketNumberHandler实例对象
        List<Long> ticketNumberList = new Vector();           //保存生成的票号

        //定义购票线程，一个线程模拟一个用户
        for (int i = 0; i < userCount; i++) {
            Thread t = new Thread() {
                public void run() {
                    //System.out.println("购票开始时间:" + System.currentTimeMillis());
                    //TicketNumberHandler handler = LazySimpleSingleton.getInstance();
                    //TicketNumberHandler handler = LazyInnerClassSingleton.getInstance();
                    LazyEnumSingleton handler = LazyEnumSingleton.getInstance(); //LazyEnumSingleton.INSTANCE;
                    handlerList.add(handler);

                    Long ticketNumber = handler.getTicketNumber();
                    ticketNumberList.add(ticketNumber);
                    //System.out.println("购票结束时间:" + System.currentTimeMillis());
                }
            };
            threadSet.add(t);
        }

        System.out.println("当前购票人数："+threadSet.size()+" 人");
        //记录购票开始时间
        long beginTime = System.currentTimeMillis();
        for(Thread t : threadSet) {
            //开始购票
            t.start();
        }
        //记录购票结束时间
        long entTime;
        //利用Iterator实现遍历
        Iterator<Thread> value = threadSet.iterator();
        while (value.hasNext()) {
            Thread tt = value.next();
            //若该线程没有结束就进行等待
            if (tt.isAlive()) {
                while (true) {
                    Thread.sleep(10);
                    if (!tt.isAlive()) {
                        break;
                    }
                }
            }
        }
        entTime = System.currentTimeMillis();
        /*while(true) {
            //除去mian线程之外的所有线程结果后在记录结束时间
            if (Thread.activeCount() == 1) {
                entTime = System.currentTimeMillis();
                break;
            }
        }*/

        //开始统计
        System.out.println("票号生成类实例对象数目："+new HashSet(handlerList).size());
        System.out.println("共出票："+ticketNumberList.size()+"张");
        System.out.println("实际出票："+new HashSet(ticketNumberList).size()+"张");
        System.out.println("出票用时："+(entTime - beginTime)+" 毫秒");
    }
}
