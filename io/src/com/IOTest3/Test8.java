package com.IOTest3;


import java.io.*;

/**
 * DataInputStream数据输入流的测试
 * 输入数据
 */
public class Test8 {
    public static void main(String[] args) {
        DataInputStream dis = null;//数据输入流对象的创建
        DataOutputStream dos = null;

        try{
            //new DataInputStream（new FileOutputStream））
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\idea-code\\TestT\\wer.txt")));
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\idea-code\\TestT\\wer.txt")));

            dos.writeUTF("I love you");
            dos.writeDouble(Math.random());
            dos.writeChar('G');
            dos.writeBoolean(false);
            dos.writeInt(123456);
            dos.flush();

            /*
            read方法，有
            readInt（），readDouble（），readUTF（）等等
            输入的类型与输出的顺序要保持一致!!!!才能读取正确
             */
            System.out.println(dis.readUTF());
            System.out.println(dis.readDouble());
            System.out.println(dis.readChar());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readInt());


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (dis!=null){
                    dis.close();
                }
                if (dos!=null){
                    dos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }
}
