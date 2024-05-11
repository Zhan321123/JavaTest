package com.awtTest1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 利用CardLayout制作查看器
 * frame中添加两个panel
 *
 * 中间的panel设置为CardLayout卡片布局
 * 并添加几个组件
 *
 * 南边的panel是flowLayout布局
 * 添加五个功能按钮
 * 每个按钮添加ActionListener
 * 设置ActionListener功能
 */
public class Test10 {
    public static void main(String[] args) {

        Frame f = Main.addFrame(300, 300, 200, 200);

        CardLayout cardLayout = new CardLayout();
        //p.setLayout(CardLayout)；
        Panel p = new Panel(cardLayout);
        for (int i = 1; i <= 7; i++) {
            p.add(i+"",new Button("Number "+i));
        }
        f.add(p);

        ActionListener actionListener =new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                switch (s){
                    case "上一张":
                        cardLayout.previous(p);
                        break;
                    case "下一张":
                        cardLayout.next(p);
                        break;
                    case "最后一张":
                        cardLayout.last(p);
                        break;
                    case "开头一张":
                        cardLayout.first(p);
                        break;
                    case "中间一张":
                        cardLayout.show(p,"4");
                        break;
                }
            }
        };

        Panel p2 = new Panel(new FlowLayout(FlowLayout.CENTER,3,3));
        for (String s : new String[]{"上一张", "下一张", "最后一张", "开头一张", "中间一张"}) {
            Button b = new Button(s);
            b.addActionListener(actionListener);
            p2.add(b);
        }


        f.add(p2,BorderLayout.SOUTH);

        f.pack();


    }
}
