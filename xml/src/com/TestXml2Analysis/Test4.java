package com.TestXml2Analysis;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * Xpath的测试，即xml的path路径
 * 要导入jaxen包
 * 可以快速定位，不用循环就能找到属性和keyValue
 * 基本用法Element.selectedNodes（""），返回List<Element>
 */
public class Test4 {
    public static void main(String[] args) throws DocumentException {
        InputStream is = Test3.class.getClassLoader().getResourceAsStream("xml3.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(is);

        //Element.selectedNodes（Element下的Element/Element/Element...）可以直接顺着元素获取相应元素
        Element root = document.getRootElement();
        List<Node> student1 = root.selectNodes("students/student/age");
        for (Node e:student1){
            System.out.println(e.getText());
        }
        System.out.println("----------------");

        //Element.selectedNodes（//Element），获取所有属性下的Element
        List<Node> list = root.selectNodes("//name");
        for (Node e:list){
            System.out.println(e.getText());
        }
        System.out.println("----------------");

        //Element.selectedNodes（Element/Element[int n]），获取第n个元素，从0开始的
        List<Node> list1 = root.selectNodes("students/student[1]");
        for (Node e:list1){
            System.out.println(e.getText());
        }
        System.out.println("----------------");

        //Element.selectedNodes（Element[last（）]），获取最后一个元素
        List<Node> list2 = root.selectNodes("students/student[last()]/name");
        for (Node e:list2){
            System.out.println(e.getText());
        }
        System.out.println("----------------");

        //Element.selectedNodes（Element[position（）>或< n]），获取某些位置的元素
        List<Node> list3 = root.selectNodes("students/student[position()>1]/id");
        for (Node e:list3){
            System.out.println(e.getText());
        }
        System.out.println("----------------");

        //Element.selectedNodes（Element[@attribute]），获取有某个属性的元素
        List<Node> list4 = root.selectNodes("students/student[@type]/age");
        for (Node e:list4){
            System.out.println(e.getText());
        }
        System.out.println("----------------");

        //Element.selectedNodes（Element[@attribute=name]），获取某个属性是什么的元素
        List<Node> list5 = root.selectNodes("students/student[@type=monitor]/name");
        for (Node e:list5){
            System.out.println(e);
        }
    }
}
