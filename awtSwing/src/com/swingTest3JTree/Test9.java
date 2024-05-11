package com.swingTest3JTree;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;

/**
 * 树组件JTree的测试
 * 就像文件管理器一样的Tree
 * 并且利用JTree下的DefaultModel模型更改tree
 */
public class Test9 {
    JFrame jf = new JFrame("test");

    //new DefaultMutableTreeNode（Object），新建节点类
    DefaultMutableTreeNode r = new DefaultMutableTreeNode("实数");
    DefaultMutableTreeNode q = new DefaultMutableTreeNode("有理数");
    DefaultMutableTreeNode n = new DefaultMutableTreeNode("自然数");
    DefaultMutableTreeNode z = new DefaultMutableTreeNode("整数");
    DefaultMutableTreeNode f = new DefaultMutableTreeNode("分数");
    DefaultMutableTreeNode x = new DefaultMutableTreeNode("小数");
    DefaultMutableTreeNode q2 = new DefaultMutableTreeNode("无理数");
    DefaultMutableTreeNode PI = new DefaultMutableTreeNode("Π");
    DefaultMutableTreeNode e = new DefaultMutableTreeNode("e");

    //new JTree（DefaultMutableTreeNode），新建以该节点为根节点的数
    JTree jt = new JTree(r);

    JPopupMenu jm = new JPopupMenu();
    JMenuItem jmi1 = new JMenuItem("添加兄弟节点");
    JMenuItem jmi2 = new JMenuItem("添加子节点");
    JMenuItem jmi3 = new JMenuItem("删除节点");
    JMenuItem jmi4 = new JMenuItem("编辑节点");
    JTextArea jta = new JTextArea(10,40);


    private void initialize(){

        init1();
        init2();
        JScrollPane jsp = new JScrollPane(jt);
        jsp.setPreferredSize(new Dimension(130,600));
        jf.add(jsp, BorderLayout.WEST);
        jf.add(jta);

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    /**
     * 对右键弹出菜单的组装
     */
    private void init2() {
        jm.add(jmi1);
        jm.add(jmi2);
        jm.add(jmi3);
        jm.add(jmi4);

        //JTree.getModel（），获取树的模型，返回TreeModel，强转为DefaultTreeModel可以编辑
        DefaultTreeModel dtm = (DefaultTreeModel) jt.getModel();

        //实现添加兄弟节点功能
        jmi1.addActionListener(e -> {
            /*
            JTree.getLastSelectionPathComponent（）
            获取最后选择的节点，返回Object，是往JTree添加的内容
            强转为DefaultMutableTreeNode可以编辑树
             */
            //获取当前节点
            DefaultMutableTreeNode d = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
            //如果当前没选节点，则返回
            if (d==null){
                return;
            }
            //DefaultMutableTreeNode.getParent（），获取父节点，没有则返回
            DefaultMutableTreeNode p = (DefaultMutableTreeNode) d.getParent();
            if (p==null){
                return;
            }
            //新建节点
            DefaultMutableTreeNode Node = new DefaultMutableTreeNode("新建文件");
            //DefaultMutableTreeNode父.getIndex（DefaultMutableTreeNode子）获取子节点在父节点的位置
            int index = p.getIndex(d);
            /*
            DefaultTreeModel.insertNodeInto（DefaultMutableTreeNode 插入的节点，父节点，int 位置）
            在该模型下在某位置插入节点
             */
            dtm.insertNodeInto(Node,p,index);
            //JTree.updateUI（），更新界面
            jt.updateUI();
        });
        //实现添加子节点
        jmi2.addActionListener(e -> {
            DefaultMutableTreeNode d = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
            if (d==null){
                return;
            }
            DefaultMutableTreeNode Node = new DefaultMutableTreeNode("新建文件");
            d.add(Node);
            jt.updateUI();
        });
        //实现删除节点
        jmi3.addActionListener(e -> {
            DefaultMutableTreeNode d = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
            if (d==null || d.isRoot()){
                return;
            }
            DefaultMutableTreeNode p = (DefaultMutableTreeNode) d.getParent();
            //父节点.remove（子节点），删除该节点下的子节点
            p.remove(d);
            jt.updateUI();
        });
        //实现编辑节点
        jmi4.addActionListener(e -> {
            //JTree.getSelectionPath(),获取该节点路径
            TreePath tp = jt.getSelectionPath();
            if (tp!=null){
                //JTree.startEditingAtPath（TreePath 树下的路径），设置节点为编辑状态
                jt.startEditingAtPath(tp);
            }
        });
    }

    /**
     * 对树结构的构建
     */
    private void init1() {
        //DefaultMutableTreeNode.add（DefaultMutableTreeNode），该节点添加子节点
        r.add(q);
        r.add(q2);
        q.add(z);
        q.add(f);
        q.add(x);
        z.add(n);
        q2.add(PI);
        q2.add(e);

        //设置右键弹出菜单
        jt.setComponentPopupMenu(jm);
        //JTree.setEditable（boolean），设置JTree是否可以编辑，默认不可以
        jt.setEditable(true);
        //JTree.getSelectionModel（），获取树的选择模式
        TreeSelectionModel selectionModel = jt.getSelectionModel();
        //TreeSelectionModel.setSelectionMode（int 选择模式），设置选择模式
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        //addTreeSelectionListener（new TreeSelectionListener（）{}），添加选择事件监听
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath tp = jt.getSelectionPath();
                if (tp != null) {
                    jta.setText(tp.toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        new Test9().initialize();
    }
}
