package com.awtTest2;

import com.awtTest1.Main;

import java.awt.*;

/**
 * FileDialog文件面板类的测试
 * 会弹出文件面板类型
 * 有打开面板，保存面板等等
 */
public class Test4 {
    public static void main(String[] args) {
        Frame f = Main.addFrame2();
        /*
        new FileDialog（Frame，String title，页面类型）
        页面类型有LOAD打开页面，SAVE保存页面等等
        当setVisible为true时会打开，程序会进入等待状态
         */
        FileDialog fileDialog = new FileDialog(f,"打开文件",FileDialog.LOAD);
        FileDialog fileDialog1 = new FileDialog(f,"保存文件",FileDialog.SAVE);

        Button b1 = new Button("打开文件");
        Button b2 = new Button("保存文件");

        f.add(b1,BorderLayout.NORTH);
        f.add(b2);

        /*
        将FileDialog.setVisible（true）时，界面就会弹出，程序开始等待
         */
        b1.addActionListener(e-> {
            fileDialog.setVisible(true);
            //程序在此处等待
            //选择好文件之后，Visible会再次设为false，程序继续运行
            String s1 = fileDialog.getDirectory();
            System.out.println(s1);
            String s2 = fileDialog.getFile();
            System.out.println(s2);
        });

        b2.addActionListener(e->{
            fileDialog1.setVisible(true);

            String s1 = fileDialog1.getDirectory();
            System.out.println(s1);
            String s2 = fileDialog1.getFile();
            System.out.println(s2);
        });

        f.pack();

    }
}
