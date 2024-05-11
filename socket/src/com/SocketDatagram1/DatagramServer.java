package com.SocketDatagram1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 利用数据报类DatagramSocket进行网络通信的服务端
 * 一次双向通信
 * 适用于双方通信，类似于向客服询问，而不是服务器
 * 在该方法中实际并没有服务端与客户端的区分，只是通过网络互相传递信息
 *
 * 方法：
 * 1.客户端与服务端创建数据报
 *     服务端开放一个端口new DatagramSocket（端口）
 *     客户端也开放一个端口new DatagramSocket（端口）
 *     要求两个端口号不一样，否则会报错，客户端可以不用指定端口，系统会自动分配端口
 * 2.客户端与服务端创建数据包
 *     客户端创建数据包new DatagramPacket（byte[]，int length，发送地址ip，端口号）
 *          byte[]是数据，length是数据byte[]0到length的长度
 *          因为发送到服务端，所以ip和端口号是服务端的
 *      服务端创建一个未指定大小的数据包new DatagramPacket（new byte[int 所需要的大小]，大小）
 * 3.发送与接收
 *      客户端发送，DatagramSocket.send（DatagramPacket）
 *      服务端接受，DatagramSocket.receive（DatagramPacket），如果没收到，就一直等待
 *          此时参数的数据包会被客户端发送的数据包覆盖，仅替换byte[]里的内容，长度不会变
 *          DatagramPacket.getData（），获取数据包的内容，返回byte[]
 * 4.反馈与接收
 *      服务端创建数据包new DatagramPacket（byte[]，length，接收到的数据包.getAddress（），接收到的数据包.getPort（））
 *      服务端发送该数据包DatagramSocket.send（DatagramPacket）
 *      客户端创建数据包new DatagramPacket（new byte[]，length）
 *      客户端接收数据包DatagramSocket.receive（DatagramPacket），此时客户端参数里的数据包就被服务端发送的数据包覆盖
 * 4.关闭端口
 *      客户端和服务端都DatagramSocket.close（）
 *
 *
 */
public class DatagramServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1212);

        byte[] bs = new byte[100];
        DatagramPacket dp = new DatagramPacket(bs,100);
        ds.receive(dp);
        System.out.println(new String(dp.getData(),0,dp.getLength()));

        String s = "I am fine! Thanks";
        DatagramPacket dp2 = new DatagramPacket(s.getBytes(),s.length(),dp.getAddress(),dp.getPort());
        ds.send(dp2);

        ds.close();

    }
}
