package com.ThreadTest6Example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 案例：四个窗口买1000张票
 * 利用Lock锁实现
 */
public class Example3 {
    public static void main(String[] args) {
        Runnable runnable = new Ticket3();
        for (int i = 0; i < 4; i++) {
            new Thread(runnable).start();
        }
    }
}
class Ticket3 implements Runnable{
    int tickets = 1000;
    Lock l = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            l.lock();
            try {
                if (tickets==0){
                    return;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("票口为"+Thread.currentThread().getName()+"  购的票位置为"+tickets);
                tickets--;
            }finally {
                l.unlock();
            }
        }
    }
}