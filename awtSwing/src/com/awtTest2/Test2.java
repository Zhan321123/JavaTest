package com.awtTest2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dialog面板类的测试
 * 与Frame大同小异
 * 不同的是可以像关闭页面是其他窗口不可操作一样设置
 */
public class Test2 {
    public static void main(String[] args) {

        Frame f = new Frame("Test1");
        f.setVisible(true);

        /*
        new Dialog（Frame，String title，boolean是否不可以操作原界面）
        新建面板对象，true时不能操作原界面
        也可以像Frame一样控制
         */
        Dialog dialog = new Dialog(f,"关闭面板",true);
        Dialog dialog2 = new Dialog(f,"面板",false);
        dialog.setBounds(600,200,100,100);
        dialog2.setBounds(900,300,100,100);

        Button b1 =new Button("关闭1");
        Button b2 = new Button("关闭2");

        f.add(b1, BorderLayout.NORTH);
        f.add(b2);

        /*
        在行为监视器中将dialog的setVisible设为true即可
         */
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog2.setVisible(true);
            }
        });

        dialog.pack();

        f.pack();


    }
}
