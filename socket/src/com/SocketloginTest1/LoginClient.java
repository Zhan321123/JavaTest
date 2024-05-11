package com.SocketloginTest1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 模拟登录的客户端
 * 双向通信的方法：在服务端
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 1234);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("name=liu&age=18");

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String s = dis.readUTF();
        System.out.println(s);

        dos.close();
        dis.close();

    }
}
