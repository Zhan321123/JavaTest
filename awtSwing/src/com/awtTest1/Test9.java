package com.awtTest1;

import java.awt.*;

/**
 * 布局管理器CardLayout的测试
 * 像卡片一样展示组件，调用各种方法可以让相应组件展示
 */
public class Test9 {
    public static void main(String[] args) {

        Frame frame =Main.addFrame(300,300,300,300);
        //new CardLayout（），创建卡片布局管理器
        CardLayout cardLayout = new CardLayout();
        Panel j = new Panel(cardLayout);//在Panel中设置布局
        //Panel.setLayout(CardLayout);

        //在Panel中添加组件
        j.add(new Button("fuck"));
        j.add(new Button("hello"));
        j.add(new Button("hi"));

        /*
        五个关于布局管理器的展示方法
        show（Panel，String name），展示panel中该名字的容器
        first（Panel），展示第一个添加到panel中的组件
        last（Panel），展示最后一个添加发哦panel中的组件、
        previous（Panel），展示上一个组件，如果是第一个，会转到最后一个
        next（Panel），展示下一个组件，如果那么
         */
        cardLayout.show(j,"hello");
        cardLayout.first(j);
        cardLayout.last(j);
        cardLayout.previous(j);
        cardLayout.next(j);

        frame.add(j);



        Frame f = Main.addFrame(600,300,300,300);
        CardLayout c = new CardLayout();
        f.setLayout(c);
        f.add(new Button("I"));
        f.add(new Button("Y"));
        c.show(f,"Y");

        f.pack();


    }
}
