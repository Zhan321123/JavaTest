package com.SocketloginTest3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 可以一直使用的服务端
 * 每次通信都会创建一个新的线程用于通信而不会互相干扰
 * 方法：
 * while true端口不停地接受，接收到就开启新线程，在新线程里接收和反馈消息
 */
public class UsersServer {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(8765);
        while (true) {

            Socket socket = ss.accept();
            new ProgressThread(socket).start();
            System.out.println(socket.getPort()+""+socket.getInetAddress());
        }

    }
}
