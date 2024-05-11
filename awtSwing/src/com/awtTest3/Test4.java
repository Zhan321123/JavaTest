package com.awtTest3;

import com.awtTest1.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 利用ImageIO读取和写入
 * 实现照片查看器的打开和保存
 */
public class Test4 {
    Frame f = Main.addFrame2();

    /*
    顶部菜单栏MenuBar和菜单项以及菜单选项
     */
    MenuBar mb = new MenuBar();
    Menu m = new Menu("file");
    MenuItem miOpen = new MenuItem("Open");
    MenuItem miSave = new MenuItem("Save");

    //创建成员变量以实现修改和使用在不同类下
    BufferedImage bi;
    private class myCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.drawImage(bi,0,0,null);
        }
    }
    myCanvas myCanvas = new myCanvas();

    private void initializing(){
        //添加打开菜单的监听
        miOpen.addActionListener(e->{
            //FileDialog打开面板
            FileDialog fd = new FileDialog(f,"Open",FileDialog.LOAD);
            fd.setVisible(true);
            String dir = fd.getDirectory();
            String fileName = fd.getFile();

            try {
                /*
                ImageIO.read（File），返回BufferedImage
                读取文件内容
                需要try和catch
                 */
                bi = ImageIO.read(new File(dir, fileName));
                myCanvas.setPreferredSize(new Dimension(bi.getWidth(),bi.getHeight()));
                f.pack();
                myCanvas.repaint();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        miSave.addActionListener(e->{
            FileDialog fd = new FileDialog(f,"Save",FileDialog.SAVE);
            fd.setVisible(true);
            String dir = fd.getDirectory();
            String fileName = fd.getFile();
            System.out.println(dir+fileName);
        });

        f.add(myCanvas);
        myCanvas.setPreferredSize(new Dimension(800,600));
        f.setMenuBar(mb);
        mb.add(m);
        m.add(miOpen);
        m.add(miSave);
        f.pack();
    }

    public static void main(String[] args) {
        new Test4().initializing();
    }



}
