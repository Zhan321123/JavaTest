package com.awtTest1;

import javax.swing.*;
import java.awt.*;

/**
 * swing包下的界面布局类BoxLayout
 * 有 ”上下方向按钮“ 和 ”左右方向按钮“ 两种类型
 */
public class Test11 {
    public static void main(String[] args) {

        Frame f2 = Main.addFrame(600,300,300,300);
        f2.setLayout(new BoxLayout(f2,0));
        f2.add(new Button("Left"));
        f2.add(new Button("Right"));
        f2.add(new Button("what"));

        Frame f = Main.addFrame(300,300,300,300);
        /*
        new BoxLayout（容器，方向）
        既要new BoxLayout的时候指定容器，又要将容器setLayout！！！
        方向是0或BoxLayout.X_AXIS时，为左右方向
        是1或Box Layout.Y_AXIS时，为上下方向
         */
        BoxLayout boxLayout = new BoxLayout(f, 1);
        f.setLayout(boxLayout);
        f.add(new Button("UP"));
        f.add(new Button("DOWN"));
        f.add(new Button("fuck"));
        f.add(new Button("hello"));


    }
}
