package com.IOTest5;

import java.io.*;
/**
 * 使用File类代替路径
 */
public class Test2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try{
            br = new BufferedReader(new FileReader(new File("D:\\idea-code\\TestT\\asd.txt")));
            bw = new BufferedWriter(new FileWriter(new File("D:\\idea-code\\TestT\\qwe.txt")));

            String s;
            for(int i=1;(s=br.readLine())!=null;i++){
                bw.write(i+"  "+s);
                bw.newLine();
            }
            bw.flush();



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (br!=null){
                    br.close();
                }
                if (bw!=null){
                    bw.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }
}
