package com.ThreadTest3;

/**
 * 线程通信问题的引入
 * 生产者与消费者两个线程之间的通信问题
 * wait（），等待，会让出CPU，释放锁
 * notify（），唤醒其他线程
 */
public class Test1 {
    public static void main(String[] args) {
        Produce p = new Produce();
        Producer per = new Producer(p);
        Thread t1 = new Thread(per);
        Consumer cer = new Consumer(p);
        Thread t2 = new Thread(cer);

        t1.start();
        t2.start();
    }
}

/**
 * 商品类
 */
class Produce {
    private String name;
    private String color;
    public boolean empty = true;

    public Produce() {
    }

    public Produce(String name, String color) {
        this.name = name;
        this.color = color;
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

/**
 * 生产者行为
 */
class Producer implements Runnable {
    private Produce produce;

    public Producer(Produce produce) {
        this.produce = produce;
    }

    @Override
    public void run() {
        while (true) {
            //利用produce作为锁将生产行为锁住
            synchronized (produce) {
                //如果produce是空就让produce等待
                while (!produce.empty) {
                    try {
                        //等待的同时会释放CPU和解锁
                        produce.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //生产两种商品
                if (Math.random() > 0.5) {
                    produce.setName("wei");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    produce.setColor("read");
                } else {
                    produce.setName("jing");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    produce.setColor("yel");
                }
                System.out.println("生产了" + produce);
                //生产完将空改为false
                produce.empty = false;
                //唤醒produce的其他线程
                produce.notify();
            }
        }
    }
}

/**
 * 消费者行为
 */
class Consumer implements Runnable {
    private Produce produce;

    public Consumer(Produce produce) {
        this.produce = produce;
    }

    @Override
    public void run() {
        while (true) {
            //也用produce将消费行为锁住
            synchronized (produce) {
                //如果商品为空，就让produce等待
                while (produce.empty) {
                    try {
                        produce.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费了" + produce);
                //消费完将空改为true
                produce.empty = true;
                //唤醒produce的其他线程
                produce.notify();
            }
        }
    }
}