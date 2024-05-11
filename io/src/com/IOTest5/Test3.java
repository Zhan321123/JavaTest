package com.IOTest5;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 对Apache库中FileUtils类的测试
 * 测试其中的方法
 */
public class Test3 {
    public static void main(String[] args) throws IOException {

        /*
        FileUtils类的readFileToString（String 路径，String 编码）
        将整个文件按照编码读取为String
         */
        String s = FileUtils.readFileToString(new File("D:\\idea-code\\TestT\\asd.txt"),"utf-8");
        System.out.println(s);
    }
}
