package com.ThreadTest5JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier循环屏障类的测试
 * 屏障即成员够了就能开门通行，循环即们还会关上
 * 用该类完成工程同步执行
 * new CyclicBarrier（int 成员数量，Runnable），创建需要多少个成员才能开门的屏障类
 * await（），进入等待，人齐后就能开门通行
 */
public class Test2 {
    //new CyclicBarrier（int 成员数量，Runnable），创建需要多少个成员才能开门的屏障类
    //人够了也会执行Runnable
    static CyclicBarrier cb = new CyclicBarrier(2,()->{
        System.out.println("Ok");
    });

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("task1 step1 end");
            try {
                //await（），进入等待，人齐后就能开门通行
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
        }).start();

        new Thread(()->{
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
        }).start();
    }
}