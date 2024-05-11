package com.ThreadTest5JUC;

import java.util.concurrent.CountDownLatch;

/**
 * 门闩类CountDownLatch类的测试
 * 像门闩一样，要打开所有门闩才能通行
 * new CountDownLatch（int num），新建有num个门闩的门闩类
 * countDown（），打开一个门闩
 * await（）让线程处于等待状态，当门闩被打开线程就继续运行
 */
public class Test1 {
    //new CountDownLatch（int num），新建有num个门闩的门闩类
    static CountDownLatch cdl = new CountDownLatch(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thanks");
                //countDown（），打开一个门闩
                cdl.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
                cdl.countDown();
            }
        }).start();

        try {
            //await（）让线程处于等待状态，当门闩被打开线程就继续运行
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fuck");
    }
}
