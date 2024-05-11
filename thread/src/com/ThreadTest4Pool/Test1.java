package com.ThreadTest4Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用，利用线程池执行大量的Runnable任务
 * ExecutorService线程池类
 * Executors线程池的工具类，像Arrays和Collections一样的工具类
 */
public class Test1 {
    public static void main(String[] args) {

        //Executors.newSingleThreadExecutor（），创建单一线程池，效率高，只有一个线程
        ExecutorService pool1 = Executors.newSingleThreadExecutor();
        //Executors.Executor.newCachedThreadPool（），创建高速数量可变线程池
        ExecutorService pool2 = Executors.newCachedThreadPool();
        //Executors.newFixedThreadPool（int 线程数量），创建固定数量的线程池
        ExecutorService pool3 = Executors.newFixedThreadPool(10);
        //Executors.newScheduledThreadPool（int 核心池数量），创建定时线程，可以延迟启动或定时启动
        ExecutorService pool4 = Executors.newScheduledThreadPool(20);

        //execute（Runnable），将Runnable任务交给线程池
        for (int i = 0; i < 200; i++) {
//            pool1.execute(new RunnableTest1(i));
//            pool1.execute(new RunnableTest1(i));
//            pool3.execute(new RunnableTest1(i));
            pool4.execute(new RunnableTest1(i));
        }

        //还要关闭线程池shutdown（）,不然不会关闭
        pool1.shutdown();
        pool2.shutdown();
        pool3.shutdown();
        pool4.shutdown();

    }

}
class RunnableTest1 implements Runnable{
    int i;

    public RunnableTest1(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Thread start:"+i);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread   end:"+i);
    }
}
