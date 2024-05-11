package com.TestXml2Analysis;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * 利用dom4j技术读取xml
 * 要导入dom4j包
 * 注意：xml文件只能放到src包下面否则会报错
 *
 * 类名.class.getClassLoader().getResourceAsStream（xml文件名），返回InputStream字节输入流
 * new SAXReader（），新建SAX阅读器
 * SAXReader.read（InputStream），读取xml文件返回Document
 * Document.getRootElement（），返回根元素Element
 * Element.elements（），返回节点元素的子元素List
 * Element.getName（），返回节点的名字String
 * Element.getData（），返回节点的数据Object
 * Element.getStringValue（），返回节点数据的名字String
 */
public class Test1 {
    public static void main(String[] args) throws DocumentException {
        //类名.class.getClassLoader().getResourceAsStream（Xml文件名）
        InputStream is = Test1.class.getClassLoader().getResourceAsStream("xml1.xml");

        //new SAXReader（），新建SAX阅读器
        SAXReader saxreader = new SAXReader();

        //SAXReader.read（InputStream），读取xml文件返回Document
        Document document = saxreader.read(is);
        //Document.getRootElement（），返回根元素
        Element root = document.getRootElement();
        //root.elements（），返回根元素的子节点元素list
        List<Element> list = root.elements();
        System.out.println(list.size());

        for (Element e : list) {
            List<Element> elements = e.elements();
            for (Element el:elements){
                System.out.println(el.getName()+":"+el.getStringValue()+":"+el.getData());
            }
            System.out.println();
        }


    }
}
