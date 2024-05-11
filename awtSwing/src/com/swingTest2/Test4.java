package com.swingTest2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 进度条加载界面ProgressMonitor的测试
 * 界面由message和进度条和一个取消按钮
 */
public class Test4 {

    Timer t;

    private void initializing(){
        /*
        new ProgressMonitor（父容器，message，String 进度条上的显示，int min，int max）
        新建进度条界面，只要创建该对象就会展示一个进度加载界面
        加载完了或者点击取消就会关闭界面
         */
        ProgressMonitor pm = new ProgressMonitor(null,"等待任务完成","完成量",0,100);
        StimulateActivity s = new StimulateActivity(100);
        new Thread(s).start();

        t = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = s.getCurrent();
                //setProgress（int）设置进度条进度
                pm.setProgress(i);

                //isCanceled（），是否点了取消，点了返回true
                if (pm.isCanceled()){
                    t.stop();
                    pm.close();
                    System.exit(0);
                }
            }
        });

        t.start();
    }

    public static void main(String[] args) {
        new Test4().initializing();
    }
}
