package com.SocketloginTest3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 多个客户端同时启动
 */
public class UsersClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getLocalHost(), 8765);

        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("name=liu&age=18");

        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String s1 = dis.readUTF();
        System.out.println(s1);

        dis.close();
        dos.close();


    }
}
