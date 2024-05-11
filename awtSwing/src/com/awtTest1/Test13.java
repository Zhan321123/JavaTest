package com.awtTest1;

import javax.swing.*;
import java.awt.*;

/**
 * swing下的Box类
 * Box将BoxLayout更方便的使用
 * 不用BoxLayout那样要双向设置
 *
 * 与Panel对应
 * Frame-Panel-组件  //  Frame-Box-组件
 *
 * 设置Box时，add顺序一致
 * 加组件，设值距离，加组件，设置距离
 * 有上下和左右两种方向
 */
public class Test13 {
    public static void main(String[] args) {
        Frame f = Main.addFrame2();

        /*
        new Box（int 0或1）
        0是x方向
        1是y方向
         */
        Box b = new Box(0);
        b.add(new Button("first"));
        b.add(Box.createGlue());//add（Box.createGlue())，设置距离为最佳距离
        b.add(new Button("second"));
        b.add(Box.createHorizontalStrut(30));//Box.createHorizontalStrut(int 距离），设置横向固定距离
        b.add(new Button("third"));
        b.add(Box.createHorizontalGlue());
        b.add(new Button("forth"));
        b.add(Box.createHorizontalStrut(10));
        f.add(b,BorderLayout.NORTH);

        Box b2 = new Box(1);
        b2.add(Box.createVerticalStrut(40));
        b2.add(new Button("hello"));
        b2.add(Box.createVerticalGlue());//Box.createVerticalGlue(),设置竖向最佳距离
        b2.add(new Button("world"));
        b2.add(Box.createVerticalStrut(20));
        b2.add(new Button("fuck"));
        f.add(b2);

        f.pack();

    }
}
