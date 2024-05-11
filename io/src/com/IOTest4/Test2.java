package com.IOTest4;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 使用ObjectInputStream类输入对象
 */
public class Test2 {
    public static void main(String[] args) {
        ObjectInputStream ois = null;

        try{
            ois = new ObjectInputStream(new FileInputStream("D:\\idea-code\\TestT\\qwe.txt"));
            /*
            直接readObject（），将对象读取
            换回超类Object，需要强转所需的对象
             */
            User u = (User) ois.readObject();
            System.out.println(u.getName());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (ois!=null){
                    ois.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
