package com.awtTest1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 新加入窗口的方法类
 */
public class Main {
    public static Frame addFrame(int x,int y,int w,int h){
        Frame f = new Frame("Test1");
        f.setBounds(x,y,w,h);
        f.setVisible(true);
        f.setBackground(new Color(37, 139, 155));
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        return f;
    }
    public static Frame addFrame2(){
        return addFrame(300,300,300,300);
    }
}
