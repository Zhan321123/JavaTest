package com.swingTest1;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * JOptionPane类下的showConfirmDialog确认窗口的测试
 * 有几个按钮
 */
public class Test7 {
    JFrame jf = new JFrame("t");
    JTextArea jta = new JTextArea(6,40);

    private void initializing(){
        jf.add(jta);

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                /*
                JOptionPane.showConfirmDialog（组件，message，title，int 窗口类型）
                窗口类型有 是，是-否，是-否-取消 等等
                返回int由点击的按钮决定，从左向右依次从0增大，所以代码也会暂停
                 */
                int i = JOptionPane.showConfirmDialog(jf, "确定要保存吗",
                        "关闭窗口", JOptionPane.YES_NO_CANCEL_OPTION);
                switch (i){
                    case 0:
                        System.out.println("文件已保存");
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("文件未保存");
                        System.exit(0);
                        break;
                    case 2:
                        break;
                }
            }
        });

        jf.setLocation(300,200);
        jf.setVisible(true);
        jf.pack();
    }

    public static void main(String[] args) {
        new Test7().initializing();
    }
}
