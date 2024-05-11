package com.ThreadTest2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 读写锁的测试
 *
 * Lock锁使用注意事项：
 * Lock.lock();
 * try{.....}finally{Lock.unlock();}
 */
public class Test3 {
    public static void main(String[] args) {

        /*
        new ReentrantReadWriteLock（），新建可重入的读写锁
        实现了ReadWriteLock而非实现Lock接口
         */
        ReadWriteLock rwl = new ReentrantReadWriteLock();

        //readLock（），获取读锁，返回Lock，读多少次都是同一把锁
        Lock readLock = rwl.readLock();
        Lock readLock1 = rwl.readLock();
        System.out.println(readLock==readLock1);

        //writeLock（），获取写锁，返回Lock
        Lock writeLock = rwl.writeLock();
        Lock writeLock1 = rwl.writeLock();
        System.out.println(writeLock==writeLock1);

        readLock.lock();
        writeLock.lock();
        readLock.unlock();
        writeLock.unlock();

    }
}
