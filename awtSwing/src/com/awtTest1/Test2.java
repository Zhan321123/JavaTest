package com.awtTest1;

import java.awt.*;

/**
 * 都窗口的简单测试
 * 包含Panel下Button和TextField
 */
public class Test2 {
    public static void main(String[] args) {
        Frame frame = new Frame();//创建window对象
        /*
         setBounds（int x,int y,int width,int height）
         相当与setLocation（）和setSize（）
         */
        frame.setBounds(200,200,400,300);
        frame.setVisible(true);

        Panel panel = new Panel();//新建面板对象
        /*
        新建文本字段对象
        new TextField（String）
         */
        TextField textField = new TextField("Fuck you,你好");

        /*
        新建按钮对象
        new Button（String）
         */
        Button button = new Button("Click");

        panel.add(textField);//先将TextField和Button两个对象添加到panel中
        panel.add(button);

        frame.add(panel);//再将panel添加到frame中



    }
}
