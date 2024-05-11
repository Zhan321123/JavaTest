package com.ThreadTest5JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用线程池装下多任务
 */
public class Test3 {
    static ExecutorService es = Executors.newFixedThreadPool(5);
    static CyclicBarrier cb = new CyclicBarrier(2,()->{
        System.out.println("Ok");
    });

    public static void main(String[] args) {
        es.submit(() -> {
            System.out.println("task1 step1 end");
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task1 step2 end");
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task1 step3 end");
        });
        es.submit(()->{
            System.out.println("task2 step1 end");
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task2 step2 end");
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task2 step3 end");
        });
    }
}
