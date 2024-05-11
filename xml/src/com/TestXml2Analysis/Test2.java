package com.TestXml2Analysis;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * 利用dom4j测试xml数据的读取和遍历
 * 读取元素的键Key、值Value、属性Attribute
 * 方法：
 * Element.attribute（String 属性的键Key），获取属性的值Value，返回Attribute
 * Attribute/Element.getName（），获取元素的键Key，返回String
 * Element.getData（），获取元素的值Value，返回Object
 * Attribute.getValue（），获取属性的Value，返回String
 */
public class Test2 {
    public static void main(String[] args) {

        try (InputStream is = Test2.class.getClassLoader().getResourceAsStream("xml2.xml")) {
            SAXReader saxReader = new SAXReader();
            Document d = saxReader.read(is);
            Element root = d.getRootElement();
            List<Element> elements = root.elements();

            for(Element e:elements){
                //Element.attribute（String 属性的键Key），获取属性的值Value，返回Attribute
                Attribute type = e.attribute("type");
                Attribute from = e.attribute("from");
                //Attribute/Element.getName（），获取元素的键Key，返回String
                //Element.getData（），获取元素的值Value，返回Object
                //Attribute.getValue（），获取属性的Value，返回String
                System.out.println(e.getName()+":"+e.element("name").getData());
                System.out.println(type.getName()+":"+type.getValue()+"   "+from.getName()+":"+from.getValue());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
