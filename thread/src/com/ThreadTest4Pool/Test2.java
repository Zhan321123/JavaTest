package com.ThreadTest4Pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 利用线程池完成大量的Callable任务
 */
public class Test2 {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Callable<Integer> callable = new CallableTest2();
            //submit（Callable），将callable任务交给线程池
            Future<Integer> submit = pool.submit(callable);
            //如果这里用get（）的话会等待线程结束得到返回值，没有发挥线程池的作用，所以将其加入list
            list.add(submit);
        }
        for (Future<Integer> f:list){
            try {
                System.out.println(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();

    }
}
class CallableTest2 implements Callable<Integer>{
    @Override
    public Integer call() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextInt(30);
    }
}