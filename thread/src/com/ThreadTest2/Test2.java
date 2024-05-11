package com.ThreadTest2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程问题解决方案2
 * 利用Lock接口的实现类
 * 将需要的地方lock（）然后再unlock（）
 */
public class Test2 {
    public static void main(String[] args) {
        Thread2 t = new Thread2();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();
        t2.start();
    }

}
class Account2{
    int money = 400;
    /*
    new ReEntrantLock（），可重入的锁
    实现了Lock接口
    可重入，即可锁定多次再解锁多次
    new ReentrantLock（true），创建公平锁，与线程排队有关
     */
    Lock lock = new ReentrantLock();

    public void withdraw(int m){


        lock.lock();
        if (m<=money){
            try {
                Thread.sleep(1000);
                money-=m;
                System.out.println("取款成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("取款失败");
        }
        lock.unlock();


    }
}
class Thread2 implements Runnable{
    Account2 account2 = new Account2();
    @Override
    public void run() {
        account2.withdraw(300);
    }
}
