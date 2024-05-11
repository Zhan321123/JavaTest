package com.ThreadTest2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic原子包下的原子类的测试
 */
public class Test6 {
    static volatile int i = 0;

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            Object o = new Object();
            new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
                    synchronized (o){
                        i++;
                    }
                }
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
class test6{
    static volatile AtomicInteger a = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        a.incrementAndGet();
                    }
                }
            }).start();
        }
        Thread.sleep(10);
        System.out.println(a);
    }
}