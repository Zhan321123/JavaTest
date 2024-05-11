package com.IOTest3;

import java.io.*;

/**
 * ObjectInputStream对象输入流的测试
 * 用于输入对象readObject
 */
public class Test10 {
    public static void main(String[] args) {

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        PrintWriter pw = null;

        try{
            //new ObjectInputStream（new File Input Stream（））
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("D:\\idea-code\\TestT\\yyy.txt")));
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\idea-code\\TestT\\yyy.txt")));
            pw = new PrintWriter(System.out);

            oos.writeUTF("I love you");
            oos.writeBoolean(true);
            oos.writeInt(235467);
            oos.writeChar('e');
            oos.writeDouble(Math.sqrt(Math.random()));
            oos.flush();

            /*
            也有各种read方法
            读取顺序需要与write顺序保持相反!!!才能正确读取
             */
            pw.println(ois.readUTF());
            pw.println(ois.readDouble());
            pw.println(ois.readChar());
            pw.println(ois.readInt());
            pw.println(ois.readBoolean());



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (oos!=null){
                    oos.close();
                }
                if (ois!=null){
                    ois.close();
                }
                if (pw!=null){
                    pw.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
