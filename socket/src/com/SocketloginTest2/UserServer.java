package com.SocketloginTest2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 通过网络登录User对象
 */
public class UserServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(2233);
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        User user = (User)ois.readObject();
        System.out.println(user);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        if (user.getName().equals("liu")){
            dos.writeUTF("welcome!"+user.getName());
        }

        ss.close();
        dos.close();
        ois.close();

    }
}
