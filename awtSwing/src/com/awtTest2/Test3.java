package com.awtTest2;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 利用Dialog实现关闭窗口的确认
 */
public class Test3 {
    public static void main(String[] args) {

        Frame f = new Frame("Test1");
        Dialog d = new Dialog(f,"close",true);
        f.add(new TextArea(6,40));

        d.setLocationRelativeTo(null);
        Button b1 = new Button("Yes");
        Button b2 = new Button("No");
        Panel p = new Panel();
        p.add(b1);
        p.add(b2);
        Panel p2 = new Panel();
        TextField tf = new TextField("是否要关闭界面", 20);
        p2.add(tf);

        d.add(p2,BorderLayout.NORTH);
        d.add(p);
        d.pack();

        b1.addActionListener(e -> System.exit(0));
        b2.addActionListener(e -> d.setVisible(false));

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                d.setVisible(true);
            }
        });

        d.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                d.setVisible(false);
            }
        });

        f.setLocation(400,300);
        f.setVisible(true);
        f.pack();

    }
}
