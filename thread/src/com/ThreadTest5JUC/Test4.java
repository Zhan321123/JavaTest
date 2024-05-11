package com.ThreadTest5JUC;

import java.util.concurrent.Semaphore;

/**
 * 信号量类Semaphore的测试
 * 许可证到达数量后就能执行任务
 * new Semaphore（int permits），新建信号量为int的信号对象
 * release（），释放一个信号量，即 permits++
 * acquire（int），当信号量>=int时，就能继续执行
 */
public class Test4 {
    //new Semaphore（int permits），新建信号量为int的信号对象
    static Semaphore s2 = new Semaphore(2);

    public static void main(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("step 1");
            //release（），释放一个信号量，即 permits++
            s2.release();
        }).start();
        new Thread(()->{
            System.out.println("step 2");
            s2.release();
        }).start();

        try {
            //acquire（int），当信号量 permits >= int 时，就能继续执行
            s2.acquire(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
