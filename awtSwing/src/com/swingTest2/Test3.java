package com.swingTest2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 进度条JProgressBar的测试
 *
 * 模拟一个下载事件进度的展示
 * 两个线程
 * 一个是下载进度
 * 一个是主程序上的计时器
 * 主程序定时监听下载进度并展示到进度条上
 */
public class Test3 {

    JFrame jf = new JFrame("test");
    JCheckBox jcb1 = new JCheckBox("t");
    JCheckBox jcb2 = new JCheckBox("m");
    /*
    new JProgressBar（int 方向，int 最小值，int 最大值）
    新建进度条
     */
    JProgressBar jpb  = new JProgressBar(JProgressBar.HORIZONTAL,0,100);

    private void initializing(){

        jcb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = jcb1.isSelected();
                //JProgressBar.setIndeterminate（boolean），设置进度条是滑块还是充能
                jpb.setIndeterminate(b);
                //setStringPainted（boolean），设置进图条是否显示数字，默认是不显示
                jpb.setStringPainted(!b);
            }
        });
        jcb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = jcb2.isSelected();
                //setBorderPainted（boolean），设置进度条是否由边框，默认有
                jpb.setBorderPainted(!b);
            }
        });

        Box b = new Box(1);
        b.add(jcb1);
        b.add(jcb2);

        jpb.setStringPainted(true);
        jpb.setBorderPainted(true);

        jf.setLayout(new FlowLayout());
        jf.add(b);
        jf.add(jpb);

        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        jf.pack();
        jf.setLocationRelativeTo(null);

        //setValue（int），设置进度条显示进度
        jpb.setValue(20);

        //线程对象的创建
        StimulateActivity sa = new StimulateActivity(jpb.getMaximum());
        //线程的开始new Thread（）.start（）
        new Thread(sa).start();

        //new Timer（int 延迟ms，new ActionListener（）{}），新建计时器对象
        Timer t = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = sa.getCurrent();
                jpb.setValue(i);
            }
        });
        //Timer.start（），计时器的开始
        t.start();

        //addChangeListener（new ChangeListener{}）
        jpb.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sa.getAmount()==jpb.getValue()){
                    //Timer.stop（），计时器停止
                    t.stop();
                }
            }
        });

    }


    public static void main(String[] args) {
        new Test3().initializing();
    }
}

/**
 * 运行线程类的创建
 * 模拟下载事件
 */
class StimulateActivity implements Runnable{

    private final int amount;//用int表示一个文件的总量
    private volatile int current;//下载的进度

    public StimulateActivity(int amount) {
        this.amount = amount;
    }

    /**
     * 这里模拟下载时的进度
     * 事实上不是这样
     */
    @Override
    public void run() {
        while(current<=amount){
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            current++;
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getCurrent() {
        return current;
    }

}