package com.awtTest2;

import com.awtTest1.Main;

import javax.swing.*;
import java.awt.*;

/**
 * 对awt下各种组件的测试
 *
 * TextArea         区域文本
 * TextField        单行文本
 * Button           按钮
 * Choice           下滑选项
 * Checkbox         判断选项
 * CheckboxGroup    单选选项组
 * List             多行文本选项
 *
 */
public class Test1 {

    Frame f = Main.addFrame2();

    /*
    new TextArea(),新建文本区域对象
    可以设置长宽
    比TextField回车能换行
     */
    TextArea textArea = new TextArea(4,20);

    /*
    new Choice（），新建滑出选项对象
    只能选择一个
     */
    Choice choice = new Choice();

    /*
    new checkbox（Label），新建判断对象
    像判断题一样选择
    new Checkbox（label，boolean），可以设置默认是开始关
     */
    Checkbox checkbox3 = new Checkbox("是否已婚");

    /*
    new CheckboxGroup（），新建选项组对象
    new Checkbox（label，CheckboxGroup，boolean），将选项组到CheckboxGroup里成为一个选择题
    只能选择一个选项
    也只能将checkbox添加到容器中，checkboxGroup不能
     */
    CheckboxGroup checkboxGroup = new CheckboxGroup();
    Checkbox checkbox = new Checkbox("男",checkboxGroup,true);
    Checkbox checkbox2 = new Checkbox("女",checkboxGroup,false);

    TextField textField = new TextField(30);

    Button button = new Button("确认");

    /*
    new list（行数，boolean 是否可以多选）新建行选择对象
    行选择
     */
    List list = new List(6,true);

    /**
     * 初始化界面，组装界面
     * 与Panel不同的是，Box可以add自身，Panel不能
     */
    public void initializing(){
        Box box = new Box(0);
        f.add(box);
        Panel p2 = new Panel();
        p2.add(textField);
        p2.add(button);
        f.add(p2,BorderLayout.SOUTH);

        Box box2 = new Box(1);
        box.add(box2);
        list.add("Red");
        list.add("Blue");
        list.add("White");
        box.add(list);

        box2.add(textArea);
        Panel p = new Panel();
        box2.add(p);

        choice.add("Red");
        choice.add("Blue");
        choice.add("White");
        p.add(choice);
        p.add(checkbox);
        p.add(checkbox2);
        p.add(checkbox3);

        f.pack();
    }


    public static void main(String[] args) {
        new Test1().initializing();
    }

}
