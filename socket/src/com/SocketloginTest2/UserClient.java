package com.SocketloginTest2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class UserClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),2233);

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        User user = new User("liu", 18, true);
        oos.writeObject(user);

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String s = dis.readUTF();
        System.out.println(s);

        oos.close();
        dis.close();
    }
}
