package com.swingTest3JTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * 利用DefaultTreeCellRenderer树单元渲染器改变JTree图标样式
 * 优：快捷方便
 * 缺：该类方法较少，修改方式单一
 * 如需绘制复杂的图标样式则继承该类
 */
public class Test10 {
    JFrame jf = new JFrame("s");

    DefaultMutableTreeNode game = new DefaultMutableTreeNode("game");
    DefaultMutableTreeNode minecraft = new DefaultMutableTreeNode("minecraft");
    DefaultMutableTreeNode study = new DefaultMutableTreeNode("study");
    DefaultMutableTreeNode gloryKing = new DefaultMutableTreeNode("gloryKing");
    DefaultMutableTreeNode weChat = new DefaultMutableTreeNode("weChat");
    DefaultMutableTreeNode QQ = new DefaultMutableTreeNode("QQ");
    DefaultMutableTreeNode myGame = new DefaultMutableTreeNode("myGame");
    DefaultMutableTreeNode GenShinImpact = new DefaultMutableTreeNode("GenShinImpact");
    JTree jt = new JTree(study);

    private void ini1(){
        study.add(game);
        study.add(QQ);
        study.add(weChat);
        game.add(gloryKing);
        game.add(GenShinImpact);
        game.add(myGame);
        myGame.add(minecraft);
    }
    private void ini2(){
        //new DefaultTreeCellRenderer（），新建默认树单元渲染器
        DefaultTreeCellRenderer dtcr = new DefaultTreeCellRenderer();
        //设置未选中节点的背景颜色
        dtcr.setBackgroundNonSelectionColor(Color.black);
        //设置选中节点的背景颜色
        dtcr.setBackgroundSelectionColor(Color.pink);
        //设置选中节点的的边框颜色
        dtcr.setBorderSelectionColor(Color.green);
        //设置关闭的文件夹的图标
        dtcr.setClosedIcon(new ImageIcon("images\\minecraft\\diamond_block.png"));
        //设置打开状态的文件夹的图标
        dtcr.setOpenIcon(new ImageIcon("images\\minecraft\\iron_block.png"));
        //设置叶子节点的图标
        dtcr.setLeafIcon(new ImageIcon("images\\minecraft\\gold_block.png"));
        //设置字体
        dtcr.setFont(new Font("黑体",Font.PLAIN,30));
        //设置未选中节点字体颜色
        dtcr.setTextNonSelectionColor(Color.cyan);
        //设置选中节点字体颜色
        dtcr.setTextSelectionColor(Color.red);

        //注意还要JTree.setCellRenderer（DefaultTreeCellRenderer），将单元渲染器设置到JTree上
        jt.setCellRenderer(dtcr);
    }
    private void initialize(){
        ini1();
        ini2();

        jf.add(new JScrollPane(jt));

        jf.setDefaultCloseOperation(3);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Test10().initialize();
    }
}
