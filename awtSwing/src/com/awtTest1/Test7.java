package com.awtTest1;

import java.awt.*;

/**
 * 界面布局类GridLayout类的测试
 * 将界面分为 行×列 的网格形状
 */
public class Test7 {
    public static void main(String[] args) {

        /*
        new GridLayout（行数，列数，行间距，列间距）
        new GridLayout（行数，列数），默认间距为0
        将界面分为 行×列 的网格
         */
        GridLayout gridLayout = new GridLayout(4,3,10,10);
        Frame f = Main.addFrame(300,200,400,400);
        f.setLayout(gridLayout);

        for (int i=0;i<9;i++){
            f.add(new Button(i+""));
        }
        f.add(new Button("+"));
        f.add(new Button("-"));
        f.add(new Button("="));

        f.pack();


    }
}
