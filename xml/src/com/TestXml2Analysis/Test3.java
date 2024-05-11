package com.TestXml2Analysis;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 利用dom4j测试xml文件的修改和写入
 *
 * 方法
 * Element.addAttribute（String 属性的Key，String 属性的Value），给元素添加属性
 * Element.addElement（String 元素的Key），给元素添加子元素，返回子元素Element
 * Element.setText（String 元素的Value），给元素设置值Value
 * new XMLWriter（OutputStream，OutputFormat），新建xml写入对象
 * new OutputStream（"\t",true,"UTF-8"），（String 每行开头，每行是否换行，读取格式）
 * XMLWriter.write（Document），将Document写入File中
 */
public class Test3 {
    public static void main(String[] args) {

        try (InputStream resourceAsStream = Test3.class.getClassLoader().getResourceAsStream("xml2.xml")) {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(resourceAsStream);
            Element root = document.getRootElement();
            Element student3 = root.addElement("student3");

            //Element.addAttribute（String 属性的Key，String 属性的Value），给元素添加属性
            student3.addAttribute("type","write");
            student3.addAttribute("from","english");
            //Element.addElement（String 元素的Key），给元素添加子元素，返回子元素Element
            //Element.setText（String 元素的Value），给元素设置值Value
            student3.addElement("name").setText("yao");
            student3.addElement("sex").setText("male");
            student3.addElement("id").setText("2023");
            //此时只是在内存里，未写入磁盘

            //写入磁盘的方法
            //new XMLWriter（OutputStream，OutputFormat），新建xml写入对象
            //new OutputStream（"\t",true,"UTF-8"），（String 每行开头，每行是否换行，读取格式）
            FileOutputStream fos = new FileOutputStream("xml\\src\\xx.xml");
            OutputFormat of = new OutputFormat("\t",true,"UTF-8");
            XMLWriter xmlWriter = new XMLWriter(fos,of);
            //XMLWriter.write（Document），将Document写入File中
            xmlWriter.write(document);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
