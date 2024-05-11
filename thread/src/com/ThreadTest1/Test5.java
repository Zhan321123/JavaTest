package com.ThreadTest1;

/**
 * 线程的join（）方法
 * 在主线程下加入该线程，该线程运行完之后才运行主线程
 * 利用该方法模拟龟兔赛跑
 */
public class Test5 {

    public static void main(String[] args) {
        int i = 1;
        while (i<=100){
            System.out.println("rabbit add oil   "+i);
            if (i==99){
                tt t = new tt();
                //线程先start（），再join（）
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
    }
}
class tt extends Thread{
    int i = 1;
    @Override
    public void run() {
        while (i<=100){
            System.out.println("turtle add oil   "+i);
            i++;
        }
    }
}