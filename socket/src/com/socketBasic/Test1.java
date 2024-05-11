package com.socketBasic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * IP地址类InetAddress
 * 只保存有IP地址
 * InetAddress.getLocalHost（），新建IP地址对象，自己主机的IP地址
 * InetAddress.getByName（String），通过地址新建IP地址对象
 *
 * getHostName（），获取主机名，返回String
 * getHostAddress（），获取主机地址，返回String，int.int.int.int
 * getAddress（），获取主机地址byte数字组，返回byte[]
 */
public class Test1 {
    public static void main(String[] args) throws UnknownHostException {
        //InetAddress.getLocalHost（），新建IP地址对象，自己主机的IP地址
        InetAddress inet1 = InetAddress.getLocalHost();
        System.out.println(inet1.toString());
        System.out.println(inet1.getHostName());//getHostName（），获取主机名，返回String
        System.out.println(inet1.getHostAddress());//getHostAddress（），获取主机地址，返回String，int.int.int.int
        System.out.println(inet1.getAddress());//getAddress（），获取主机地址byte数字组，返回byte[]
        System.out.println(Arrays.toString(inet1.getAddress()));
        System.out.println("---------------------------");

        //InetAddress.getByName（String），通过地址新建IP地址对象
        InetAddress inet2 = InetAddress.getByName("www.mcmod.cn");
        System.out.println(inet2);
        System.out.println(inet2.getHostName());
        System.out.println(inet2.getHostAddress());
        System.out.println(Arrays.toString(inet2.getAddress()));
    }
}
