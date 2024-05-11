package com.IOTest5;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 测试Apache包下IOUtils类的方法
 */
public class Test5 {
    public static void main(String[] args) throws IOException {

        /*
        IOUtils.toString（new FileInputStream（String 文件路径），编码）
        将文件输入，整个文件按编码读取为String
         */
        String s = IOUtils.toString(new FileInputStream(new File("D:\\idea-code\\TestT\\asd.txt")), StandardCharsets.UTF_8);
        System.out.println(s);


    }
}
