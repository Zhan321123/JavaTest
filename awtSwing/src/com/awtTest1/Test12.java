package com.awtTest1;

import javax.swing.*;
import java.awt.*;

/**
 * 利用BoxLayout界面布局设置一些界面
 */
public class Test12 {
    public static void main(String[] args) {

        Frame frame = Main.addFrame2();
        frame.setLayout(new BoxLayout(frame,1));

        Panel p1 = new Panel();
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
        p1.add(new Button("1"));
        p1.add(new Button("2"));
        frame.add(p1);

        Panel p2 = new Panel();
        p2.setLayout(new BoxLayout(p2,BoxLayout.X_AXIS));
        p2.add(new Button("3"));
        p2.add(new Button("4"));
        frame.add(p2);


    }
}
