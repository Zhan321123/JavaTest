package com.awtTest2;

import com.awtTest1.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 实现TextField和Frame和Choice的部分事件监听
 */
public class Test6 {
    Frame f = Main.addFrame2();
    TextField tf = new TextField(30);
    Choice c = new Choice();

    private void initializing(){
        c.add("绿色");
        c.add("蓝色");
        c.add("红色");

        Box b = new Box(BoxLayout.X_AXIS);
        b.add(c);
        b.add(tf);
        f.add(b);
        f.pack();

        //addContainerListener（new ContainerAdapt（）{}）
        //容器添加或删除的事件监听
        f.addContainerListener(new ContainerAdapter() {

            //componentAdded(ContainEvent e)
            //重写添加时的事件监听
            @Override
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();
                System.out.println(child);
            }

            //componentRemoved，移除时的事件监听
            @Override
            public void componentRemoved(ContainerEvent e) {

            }
        });

        //addTextListener（new TextListener（）{}）
        //添加文本内容变化的事件监听
        tf.addTextListener(new TextListener() {
            //textValueChanged（TextEvent）
            //重写文本改变时的事件监听
            @Override
            public void textValueChanged(TextEvent e) {
                String s = tf.getText();
                System.out.println(s);
            }
        });

        //addItemListener（new ItemListener（）{}）
        //添加选项变化的事件监听
        c.addItemListener(new ItemListener() {
            //重写addStateChanged（ItemEvent e）
            @Override
            public void itemStateChanged(ItemEvent e) {
                String s = c.getSelectedItem();
                System.out.println(s);
            }
        });


    }

    public static void main(String[] args) {
        new Test6().initializing();
    }



}
