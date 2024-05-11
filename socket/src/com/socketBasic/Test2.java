package com.socketBasic;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * InetSocketAddress套数字IP地址类，包含有IP地址和端口
 * new InetSocketAddress（InetAddress，int port），通过IP地址和端口数字新建套数字IP地址
 * new InetSocketAddress（String IP地址，int port）
 * get.getPort（），获取端口数字，返回int
 */
public class Test2 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet1 = InetAddress.getByName("www.mcmod.cn");
        //new InetSocketAddress（InetAddress，int port），通过IP地址和端口数字新建套数字IP地址
        InetSocketAddress isa = new InetSocketAddress(inet1,1234);
        //new InetSocketAddress（String IP地址，int port）
        InetSocketAddress isa2 = new InetSocketAddress("www.mcmod.cn",123);

        System.out.println(isa);
        System.out.println(isa.getAddress());
        System.out.println(isa.getHostName());
        System.out.println(isa.getPort());//get.getPort（），获取端口数字，返回int
    }
}
