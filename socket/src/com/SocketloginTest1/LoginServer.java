package com.SocketloginTest1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 通过网络进行通信
 * 模拟登录的服务端
 *
 * 双向通信的方法：
 * 一、搭建服务端与客户端环境
 *      1.服务端新建一个端口，new ServerSocket（int 某个固定端口号）
 *      2.客户端访问服务端的ip和端口，new Socket（服务端IP，该端口）
 *      3.服务端接受请求ServerSocket.accept（），返回Socket，
 *          包含有客户端的ip地址和信息
 *          如果没接收到，就一直等待，代码会停滞
 *          要先启动服务端，再启动客户端
 * 二、客户端发送给服务端信息
 *      4.客户端在Socket上输入信息，new DataOutputStream（Socket.getOutputStream（））.write（内容）
 *      5.服务端获取Socket上的信息，new DataInputStream（Socket.getInputStream（））.read（），返回内容
 * 三、服务端返回给客户端信息
 *      6.服务端在Socket上输入信息，new DataOutputStream（Socket.getOutputStream（））.write（内容）
 *      7.客户端获取Socket上的信息，new DataOutputStream（Socket.getInputStream（））.read（），返回内容
 * 四、客户端和服务端关流
 *      8.服务端关闭输入流、输出流、服务端口ServerSocket.close（）
 *      8.客户端关闭输入流、输出流
 *
 */
public class LoginServer {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(1234);
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String s = dis.readUTF();
        System.out.println(s);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("accept");

        dis.close();
        ss.close();
        dos.close();

    }
}
