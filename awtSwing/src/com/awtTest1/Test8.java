package com.awtTest1;

import java.awt.*;

/**
 * 利用GridLayout界面布局
 * 写一个计算器界面布局项目
 * 先将两个Panel添加到Frame的北边和中间
 * 北边的Panel添加一个TextField，中间的Panel添加功能Button
 *
 * 可以理解为三圈，外面是Frame，中间是Panel，里面是TextField和Button
 */
public class Test8 {
    public static void main(String[] args) {

        Frame f = Main.addFrame(300,300,400,400);

        Panel p = new Panel();
        p.add(new TextField(25));
        f.add(p,BorderLayout.NORTH);

        Panel p1 = new Panel(new GridLayout(3,5,5,5));
        for (int i=0;i<10;i++){
            p1.add(new Button(i+""));
        }
        for (String s: new String[]{"+", "-", "*", "/", "="}){
            p1.add(new Button(s));
        }
        f.add(p1);

        f.pack();

    }
}
