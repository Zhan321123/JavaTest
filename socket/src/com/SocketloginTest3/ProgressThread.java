package com.SocketloginTest3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 处理每次通信的线程类
 */
public class ProgressThread extends Thread {
    private final Socket socket;

    public ProgressThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is);
        ) {

            String s = dis.readUTF();
            System.out.println(s);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("hello!" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
