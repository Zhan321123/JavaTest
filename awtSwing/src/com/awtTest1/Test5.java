package com.awtTest1;

import java.awt.*;

/**
 * 窗口布局类BorderLayout类的测试
 * 布局有东西南北中五个位置
 */
public class Test5 {
    public static void main(String[] args) {

        Frame f = Main.addFrame(100,100,400,500);

        /*
        new BorderLayout（行距，列距）
        或new BorderLayout（），默认时，行列间距为0
         */
        BorderLayout borderLayout = new BorderLayout(30,5);
        f.setLayout(borderLayout);//也要setLayout

        /*
        add（东西，BorderLayout.方向），在指定位置放置东西
        某方向没有东西，会被其他东西占领
         */
        f.add(new Button("north"),BorderLayout.NORTH);
        f.add(new Button("east"),BorderLayout.EAST);
        f.add(new Button("south"),BorderLayout.SOUTH);
        f.add(new Button("west"), BorderLayout.WEST);
        //add（东西）就是add（东西，BorderLayout.CENTER）
        f.add(new Button("center"),BorderLayout.CENTER);

        f.pack();


    }
}
