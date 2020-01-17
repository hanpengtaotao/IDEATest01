package com.han.threadtest;

import java.util.concurrent.*;

/**
 * @author HPT
 * @version 1.0
 * @package com.han.threadtest
 * @date 2020/1/17 0017 10:30
 */
public class CreateThreads {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("-------------------------使用继承Thread类的run实现多线程Start----------------------------------");
        //继承Thread类实现多线程，重写run方法（其实Thread类本身也实现了Runnable接口）
        //每次创建一个新的线程，都要新建一个Thread子类的对象，无返回值
        for (int i = 0; i < 10; i++) {
            new ExtendThread().run();
        }

        Thread.sleep(1000);
        System.out.println("-------------------------使用实现Runnable接口的run实现多线程Start----------------------------------");
        //实现Runnable接口实现run方法
        //不论创建多少个线程，只需要创建一个Runnable接口实现类的对象，无返回值
        for(int i=0;i<10;i++) {
            ImpRunable impRunable=new ImpRunable();
            new Thread(impRunable).start();
        }

        Thread.sleep(1000);
        System.out.println("-------------------------使用实现Callable接口的call实现多线程Start----------------------------------");
        //自定义类实现Callable接口时，必须指定泛型，该泛型即返回值的类型
        //每次创建一个新的线程，都要创建一个新的Callable接口的实现类,有返回值
        for(int i=0;i<10;i++) {
            Callable<Integer> implCallable = new ImpCallable();
            FutureTask<Integer> futureTask = new FutureTask<Integer>(implCallable);
            Thread t = new Thread(futureTask);
            t.start();
            System.out.println(t.getName() + "----" + futureTask.get());
        }

        Thread.sleep(1000);
        System.out.println("-------------------------使用线程池实现多线程Start----------------------------------");
        /**
         *
         * 线程池
         * 跟数据库连接池类似
         * 避免了线程的创建和销毁造成的额外开销
         *
         * java.util.concurrent
         *
         * Executor    负责现成的使用和调度的根接口
         *    |--ExecutorService    线程池的主要接口
         *          |--ThreadPoolExecutor    线程池的实现类
         *          |--ScheduledExecutorService    接口，负责线程的调度
         *              |--ScheduledThreadPoolExecutor    (extends ThreadPoolExecutor implements ScheduledExecutorService)
         *
         *
         * Executors工具类
         * 提供了创建线程池的方法
         *
         */
        //使用Executors工具类中的方法创建线程池
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        //为线程池中的线程分配任务,使用submit方法，传入的参数可以是Runnable的实现类，也可以是Callable的实现类
        for(int i=1;i<=5;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    int j = 0;
                    while (j <= 50) {
                        System.out.println(Thread.currentThread().getName() + "---" + j++);
                    }
                }
            });
        }
        //关闭线程池
        //shutdown ： 以一种平和的方式关闭线程池，在关闭线程池之前，会等待线程池中的所有的任务都结束，不在接受新任务
        //shutdownNow ： 立即关闭线程池
        executorService.shutdown();

        Thread.sleep(1000);
        System.out.println("-------------------------使用线程池实现多线程Start1----------------------------------");
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++) {
            Future<Integer> future = executorService1.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int result = 0;
                    for (int j = 0; j <= 10; j++) {
                        result += j;
                    }
                    return result;
                }
            });

            try {
                System.out.println(Thread.currentThread().getName() + "--" + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService1.shutdown();
    }
}

class ExtendThread extends Thread {
    @Override
    public void run() {
        System.out.println("当前线程名称：" + this.getName() + " 当前线程编号：" + this.getId());
    }
}

class ImpRunable implements Runnable {
    private static volatile int i = 0;

    @Override
    public void run() {
        System.out.println("当前线程名称：" + Thread.currentThread().getName() + " 当前线程编号：" + Thread.currentThread().getId() + "    " + i++);
    }
}

class ImpCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += i;
        }
        System.out.println("当前线程名称：" + Thread.currentThread().getName() + " 当前线程编号：" + Thread.currentThread().getId());
        return result;
    }
}
