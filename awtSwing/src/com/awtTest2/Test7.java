package com.awtTest2;

import com.awtTest1.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * 菜单项的测试
 * 有
 * MenuBar顶部菜单条
 * Menu菜单，可以在顶部菜单，也可以在下拉菜单中
 * MenuItem菜单选项
 */
public class Test7 {
    Frame f = Main.addFrame2();

    //new MenuBar（），新建顶部菜单
    MenuBar menuBar = new MenuBar();

    /*
    new Menu（label），新建菜单
    可以是顶部菜单，也可以是选项菜单
     */
    Menu menu1 = new Menu("file");
    Menu menu2 = new Menu("edit");
    Menu menu3 = new Menu("help");

    /*
    new MenuItem（label）
    新建菜单选项
    new MenuItem（label，new MenuShortcut）；
    新建菜单选项，并附加快捷键
    new MenuShortcut（KeyEvent_VK_键盘字符,boolean 是否要加Shift），
    新建快捷键，时Ctrl+Shift+字符
     */
    MenuItem menuItem1 = new MenuItem("open");
    MenuItem menuItem2 = new MenuItem("long distance develop");
    MenuItem menuItem3 = new MenuItem("revoke",new MenuShortcut(KeyEvent.VK_Z,false));
    MenuItem menuItem4 = new MenuItem("cut");

    Menu menu4 = new Menu("new");
    MenuItem menuItem41 = new MenuItem("project");
    MenuItem menuItem42 = new MenuItem("java class");

    TextArea textArea = new TextArea(6,40);

    public void initializing(){

        f.add(textArea);

        f.setMenuBar(menuBar);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        menu1.add(menu4);
        menu1.add(menuItem1);
        menu1.add(menuItem2);

        menu2.add(menuItem3);
        //menu.add("-")，在菜单上加上分隔
        menu2.add("-");
        menu2.add(menuItem4);

        menu4.add(menuItem41);
        menu4.add(menuItem42);

        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(" ");
            }
        });

        f.pack();
    }

    public static void main(String[] args) {
        new Test7().initializing();
    }

}
