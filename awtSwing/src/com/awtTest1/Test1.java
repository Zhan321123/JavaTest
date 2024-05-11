package com.awtTest1;

import java.awt.*;

/**
 * awt下Frame类的测试
 *
 */
public class Test1 {
    public static void main(String[] args) {
        //Frame对象的创建
        //有无参的和参数为标题的
        Frame f = new Frame();//new Frame（）
        Frame frame = new Frame("Test1");

        frame.setVisible(true);//setVisible（boolean），窗口是否可变
        frame.setSize(400,300);//setSize（int width，int height），设置窗口长宽
        frame.setLocation(300,300);//setLocation（int x，int y），设置窗口位置
        frame.setBackground(new Color(34, 65, 159));//setBackground（new Color），设置窗口背景颜色
        frame.setResizable(false);//setResizable（boolean），设置窗口大小是否可以调整
        frame.setTitle("T");//setTitle（String），设置窗口标题

    }
}
