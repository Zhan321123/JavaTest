package com.swingTest2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
/**
 * JSplitPane拆分窗格类的测试
 * 像PS上的窗口，超过某些界面大小时无法拉动
 *
 * 用此类创建书籍查看的小项目
 *
 * 注意点
 * JLabel的大小可以是图片的大小决定，JSplitPane无法覆盖图片，因此如果图片过大超过屏幕大小，拉动杆在图片上，完全无法拉动
 */
public class Test1 {

    JFrame jf = new JFrame("Book");
    book[] bs = new book[]{
            new book("孟菲斯", "由孟菲斯创作，适合用于学习广告", new ImageIcon("images\\icon\\1.jpg")),
            new book("极繁主义", "由极其繁杂的内容，适合做激励广告", new ImageIcon("images\\icon\\2.jpg")),
            new book("漫画风格", "由漫画界面组成，适合做食品广告", new ImageIcon("images\\icon\\3.jpg")),
            new book("维多利亚", "由欧洲中世纪的魔法元素组成的书籍表面", new ImageIcon("images\\icon\\4.jpg"))
    };

    /*
    new JList<>（数组）
    相当于列单选选择
    后面可以用getSelectedValue获取数组元素
     */
    JList<book> jl = new JList<>(bs);
    //创建JLabel可以setIcon改变图标，而不用Canvas或JPanel
    JLabel jLabel = new JLabel();
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);


    private void initializing() {

        jl.setPreferredSize(new Dimension(200,800));
        jLabel.setPreferredSize(new Dimension(500,710));

        //JList.addListSelectionListener（new ListSelectionListener（）{}），添加选择事件监听器
        jl.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //JList.getSelectionValue（），获取点击的对象
                book b = jl.getSelectedValue();
                jta.setText(b.getDescription());
                jLabel.setIcon(b.getIcon());
            }
        });

        /*
        new JSplitPane（int 方向，组件，组件）

        setOneTouchExpandable（boolean）
        设置一键拖动到头尾，默认时false
        setContinuousLayout（boolean）
        是否支持连续拖动，即拖动时界面连续变化，默认是false
         */
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jLabel,jsp);
        jSplitPane.setOneTouchExpandable(true);
        JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jSplitPane,jl);
        jSplitPane1.setContinuousLayout(true);

        jf.add(jSplitPane1);

        jf.setVisible(true);
        jf.setLocation(300, 100);
        jf.setDefaultCloseOperation(3);
        jf.pack();
    }

    public static void main(String[] args) {
        new Test1().initializing();
    }


}
/**
 * 书籍对象
 * 要重写toString方法，这样在JList中选项不是对象位置
 */
class book {
    private String name;
    private String description;
    private Icon icon;

    public book(String name, String description, Icon icon) {
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return this.name;
    }
}