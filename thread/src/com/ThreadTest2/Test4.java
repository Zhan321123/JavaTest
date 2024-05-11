package com.ThreadTest2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁的优点展示
 * readLock（）读锁有多把钥匙，可以多线程同步运行，实现高效
 * writeLock（）写锁仅一把钥匙，只能让单一线程运行，实现安全
 */
public class Test4 {
//    static Lock l = new ReentrantLock();
    static ReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void read() {
//        l.lock();
        rwl.readLock().lock();
        System.out.println("----read start----" + Thread.currentThread().getName());
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----read end----" + Thread.currentThread().getName());
//        l.unlock();
        rwl.readLock().unlock();
    }

    public static void write() {
//        l.lock();
        rwl.writeLock().lock();
        System.out.println("----write start----" + Thread.currentThread().getName());
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----write end----" + Thread.currentThread().getName());
//        l.unlock();
        rwl.writeLock().unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> read()).start();
            new Thread(Test4::write).start();
        }

    }
}
