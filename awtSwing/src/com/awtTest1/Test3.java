package com.awtTest1;

import java.awt.*;

/**
 * 对滚动面板ScrollPane的测试
 */
public class Test3 {
    public static void main(String[] args) {

        Frame frame = Main.addFrame(200, 200, 400, 300);

        /*
        新建滚动面板
        new ScrollPane（），默认情况下内容超出frame才添加滚轮
        如果一定要添加滚轮，就new ScrollPane（1） 或 new ScrollPane（SCROLLBARS_ALWAYS）
         */
        ScrollPane sp1 = new ScrollPane(1);
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        ScrollPane scrollPane = new ScrollPane();

        TextField textField = new TextField(
                "123456789976543212235654785345678" +
                        "909876543212345678998523456789923" +
                        "456789023456789983456217623456789");

        sp.add(textField);//仍然要add（）
        frame.add(sp);//仍然要被frame.add



    }
}
