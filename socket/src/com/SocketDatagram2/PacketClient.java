package com.SocketDatagram2;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Datagram数据报传递数据包的客户端
 */
public class PacketClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();

        while (true) {
            String s = scanner.nextLine();
            DatagramPacket dpSend = new DatagramPacket(s.getBytes(), s.length(), InetAddress.getLocalHost(), 8888);
            ds.send(dpSend);

            DatagramPacket dpReceive = new DatagramPacket(new byte[100], 100);
            ds.receive(dpReceive);
            String answer = new String(dpReceive.getData(), 0, dpReceive.getLength());
            System.out.println(answer);
            if (answer.equals("bye")){
                ds.close();
                break;
            }

        }

    }
}
