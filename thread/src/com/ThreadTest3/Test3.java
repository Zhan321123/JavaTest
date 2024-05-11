package com.ThreadTest3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 升级Test2，多个生产者和多个消费者，并是实现精准唤醒某些线程
 * Lock锁下的Condition线程等待队列
 * Condition的方法：
 * await（），该队列线程等待
 * signal（），唤醒队列线程的某一个
 * signalAll（），唤醒队列所有线程
 * 注意：这些方法都要在Lock.lock（）状态下才对
 */
public class Test3 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Product3 p = new Product3();
            //Lambda表达式的使用
            new Thread(p::produce).start();
            new Thread(() -> p.consume()).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    p.statistics();
                }
            }).start();
        }
    }
}

class Product3 {

    private String name;
    private String color;
    public boolean empty = true;
    Lock lock = new ReentrantLock();
    //lock.newCondition()，创建状态线程队列
    Condition consumeCondition = lock.newCondition();
    Condition productCondition = lock.newCondition();
    //记录生产和消费情况
    int con = 0;
    int pro = 0;

    public Product3() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void consume() {
        lock.lock();
        try {
            while (true) {
                while (this.empty) {
                    try {
                        consumeCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费了" + this+Thread.currentThread().getName());
                con++;
                this.empty = true;
                productCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void produce() {
        lock.lock();
        try {
            while (true) {
                while (!empty) {
                    try {
                        productCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (Math.random() > 0.5) {
                    this.setName("wei");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.setColor("read");
                } else {
                    this.setName("jing");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.setColor("yel");
                }
                System.out.println("生产了" + this+Thread.currentThread().getName());
                pro++;
                this.empty = false;
                consumeCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
    public void statistics(){
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consume:" + con);
            System.out.println("produce:" + pro);
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
