package com.awtTest1;

import java.awt.*;
/**
 * 界面布局器与Panel的结合使用
 */
public class Test6 {
    public static void main(String[] args) {

        BorderLayout bl = new BorderLayout();
        Frame f = Main.addFrame(100,100,100,100);
        f.setLayout(bl);

        f.add(new TextField("fuck"),BorderLayout.SOUTH);
        f.add(new Button("button"), BorderLayout.NORTH);
        f.add(new Button("what"),BorderLayout.EAST);

        Panel p = new Panel();
        p.add(new Button("hello"));
        p.add(new TextField("234"));
        f.add(p);

        f.pack();

    }
}
