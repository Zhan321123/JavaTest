package com.ThreadTest6Example;

/**
 * 案例：四个窗口买1000张票
 * 利用锁方法实现
 */
public class Example2 {
    public static void main(String[] args) {
        Runnable runnable = new Ticket2();
        for (int i = 0; i < 4; i++) {
            new Thread(runnable).start();
        }
    }
}
class Ticket2 implements Runnable{
    int tickets = 1000;
    @Override
    public void run() {
        while (true){
            sellOne();
            if (tickets==0){
                break;
            }
        }
    }
    private synchronized void sellOne(){
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
    }
}