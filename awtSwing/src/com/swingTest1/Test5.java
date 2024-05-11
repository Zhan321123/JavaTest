package com.swingTest1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 上次打开和保存界面FileDialog时awt用的是操作系统的界面
 * 这次JFileChooser是swing用的自己的界面
 * 实现文件的打开和保存界面
 */
public class Test5 {
    JFrame jf = new JFrame("Photo");
    JMenuBar jmb = new JMenuBar();
    JMenu jm = new JMenu("file");

    //new 组件.（new AbstractAction（String name））
    //可以让让给组件添加事件监听的同时赋予组件名字
    JMenuItem jmi1 = new JMenuItem(new AbstractAction("open") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //new JFileChooser（"."），文件相对位置是本项目
            JFileChooser jfc = new JFileChooser(".");
            //showOpenDialog（组件），打开文件打开界面
            jfc.showOpenDialog(jf);

            //getSelectedFile（），获取文件位置
            File f = jfc.getSelectedFile();

            try {
                bi = ImageIO.read(f);

                myJPanel.repaint();
                myJPanel.setPreferredSize(new Dimension(bi.getWidth(),bi.getHeight()));
                jf.pack();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });
    JMenuItem jmi2 = new JMenuItem(new AbstractAction("save") {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jfc = new JFileChooser(".");
            //showSaveDialog（组件），打开保存界面
            jfc.showSaveDialog(jf);
            File f = jfc.getSelectedFile();

            try {
                ImageIO.write(bi,"",f);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });

    BufferedImage bi;

    private class myJPanel extends JPanel{
        @Override
        public void paint(Graphics g) {
            g.drawImage(bi,0,0,null);
        }
    }

    myJPanel myJPanel = new myJPanel();

    private void initializing(){
        jf.setDefaultCloseOperation(3);
        jf.setLocation(200,100);
        jf.setVisible(true);
        jf.setJMenuBar(jmb);

        jmb.add(jm);
        jm.add(jmi1);
        jm.add(jmi2);
        jf.add(myJPanel);
        myJPanel.setPreferredSize(new Dimension(400,400));

        jf.pack();

    }

    public static void main(String[] args) {
        new Test5().initializing();
    }
}
