package com.SocketDatagram1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 利用数据报类DatagramSocket进行网络通信的客户端
 * 方法在服务端
 */
public class DatagramClient {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();
        String s = "hello! Zhan.How are you?";
        DatagramPacket packet = new DatagramPacket(s.getBytes(), s.length(), InetAddress.getLocalHost(), 1212);
        ds.send(packet);

        byte[] bs = new byte[100];
        DatagramPacket dp2 = new DatagramPacket(bs,100);
        ds.receive(dp2);
        System.out.println(new String(dp2.getData(),0,dp2.getLength()));

        ds.close();
    }
}
