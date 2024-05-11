package com.ThreadTest1;

/**
 * 线程的小测试
 * 第一次启动多线程
 * Thread.currentThread()获取当前线程
 */
public class Test1 {
    public static void main(String[] args) {

        Thread thread = new RabbitThread();
        //start（），线程的启动，与run（）不同，run是在该线程上运行，即运行完该线程才继续运行main线程
//        thread.run();
        thread.start();

        while (true){
            System.out.println("乌龟在跑"+Thread.currentThread().getName()+"   "+Thread.currentThread().getPriority());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

/**
 * 自定义类继承Thread线程类
 * 重写run方法，即该线程的任务
 */
class RabbitThread extends Thread{

    @Override
    public void run() {
        while (true) {
            System.out.println("兔子在跑" + this.getName() + "   " + this.getPriority());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
