package com.ThreadTest6Example;

/**
 * 案例：四个窗口买1000张票
 * 利用synchronized锁代码块实现
 */
public class Example1 {
    public static void main(String[] args) {
        Runnable runnable = new TicketRunnable();
        for (int i = 0; i < 4; i++) {
            new Thread(runnable).start();
        }
    }
}

class TicketRunnable implements Runnable {
    int tickets = 1000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets == 0) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("窗口" + Thread.currentThread().getName() + "第几张票数" + tickets);
                tickets--;
            }
        }
    }
}