package com.SocketDatagram2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * Datagram数据报传递数据包的服务端
 * 实现多次双向通信
 */
public class PacketServer {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket(8888);

        while (true) {

            DatagramPacket dpReceive = new DatagramPacket(new byte[100], 100);
            ds.receive(dpReceive);
            System.out.println(new String(dpReceive.getData(), 0, dpReceive.getLength()));

            String s = scanner.nextLine();
            DatagramPacket dpSend = new DatagramPacket(s.getBytes(), s.length(), dpReceive.getAddress(), dpReceive.getPort());
            ds.send(dpSend);
            if (s.equals("bye")) {
                ds.close();
                break;
            }
        }

    }
}
