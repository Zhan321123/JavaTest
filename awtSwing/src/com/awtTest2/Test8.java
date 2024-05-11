package com.awtTest2;

import com.awtTest1.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

/**
 * 弹出选项菜单PopupMenu类的测试
 */
public class Test8 {
    Frame f = Main.addFrame2();

    //new PopupMenu（），新建弹出菜单
    PopupMenu popupMenu = new PopupMenu();

    MenuItem menuItem1 = new MenuItem("copy");
    MenuItem menuItem2 = new MenuItem("delete");
    MenuItem menuItem3 = new MenuItem("fuck");

    Panel p = new Panel();
    TextArea ta = new TextArea(4,40);

    public void initializing(){
        f.add(ta, BorderLayout.NORTH);
        f.add(p);

        //Panel.setPreferredSize（new Dimension（width，height）），设置更好的菜单大小
        p.setPreferredSize(new Dimension(40,100));
        p.add(popupMenu);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                ta.append(s+"\n");
            }
        };

        for (MenuItem menuItem : Arrays.asList(menuItem1, menuItem2, menuItem3)) {
            popupMenu.add(menuItem);
            menuItem.addActionListener(al);
        }

        //添加鼠标事件addMouseListener（new MouseAdapter（）{}）
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*
                鼠标getButton（）
                左键为1，中键为2，右键为3
                 */
                if (e.getButton()==3){
                    popupMenu.show(p,e.getX(),e.getY());
                }
            }
        });

        f.pack();
    }

    public static void main(String[] args) {
        new Test8().initializing();
    }



}
