package com.socketBasic;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 统一资源定位器类URL，包含IP地址、资源地址、访问地址等等
 * new URL（String IP网址+其他地址），新建URL
 *
 * getProtocol（），获取协议，返回String：http https telnet等等
 * getDefaultPort（），获取默认端口
 * getPath()
 * getFile()
 * getRef()，获取编号，String
 * getQuery()，获取查询，返回String
 *
 */
public class Test3 {
    public static void main(String[] args) throws MalformedURLException {
        URL url1 = new URL("https://search.mcmod.cn/s?key=%E9%99%84%E9%AD%94");
        URL url2 = new URL("https://www.mcmod.cn/class/834.html");
        System.out.println(url1);
        System.out.println(url1.getProtocol());
        System.out.println(url1.getHost());
        System.out.println(url1.getDefaultPort());
        System.out.println(url1.getPort());
        System.out.println(url1.getPath());
        System.out.println(url1.getFile());
        System.out.println(url1.getRef());
        System.out.println(url1.getQuery());
    }
}
