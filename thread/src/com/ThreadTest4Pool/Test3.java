package com.ThreadTest4Pool;

import java.util.concurrent.RecursiveTask;

/**
 * 利用ForkJoin线程分叉再合并类实现单任务多核共同完成
 * 继承RecursionTask<>任务
 * 再computer方法下用fork（）方法将任务分出
 * 分出的任务会交给其他线程去完成
 * 再用join（）方法将任务合并
 * 最后输出结果
 */
public class Test3 {
    public static void main(String[] args) {

        //在单线程下计算斐波那契数列前n项和
        long n = 1000000000;

        long start = System.currentTimeMillis();
        long n0 = 1;//An
        long n1 = 1;//An+1
        int sum = 1;
        for (long i = 1; i < n; i++) {
            long s = n1;
            n1 = n1 + n0;//An+2 = An+1 + An
            n0 = s;
            sum+=n0;
        }
        long end = System.currentTimeMillis();
        System.out.println(sum+"   "+(end-start));

        //利用ForkJoin类计算斐波那契
        start = System.currentTimeMillis();
        Fibonacci f = new Fibonacci(n);
        end = System.currentTimeMillis();
        System.out.println(f.compute()+"   "+(end-start));

    }
}

class Fibonacci extends RecursiveTask<Long> {
    final Long n;

    Fibonacci(Long n) {
        this.n = n;
    }

    public Long compute() {
        if (n <= 1) return n;
        //迭代分出新任务
        Fibonacci f1 = new Fibonacci(n - 1);
        //新任务.fork（），将任务分支出去
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        //老任务任务.join（），返回老任务的计算结果T，将老任务结果提出来
        return f2.compute() + f1.join();
    }
}