package com.test1Jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * 使用PrepareStatement解决字符串拼接出现的问题
 */
public class Test6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("account");
        String account = scanner.nextLine();
        System.out.println("password");
        String password = scanner.nextLine();

        User user = find(account, password);
        System.out.println(user);


    }

    private static User find(String account,String password) {
        User u = null;
        String name;
        int money;


        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String mysqlPassword = "987654321asd";
        //需要填写的地方用？表示
        String sql = "select * from money where account = ? and password = ?";
        try (
                Connection connection = DriverManager.getConnection(url, user, mysqlPassword);
                //Connection.prepareStatement（String sql），创建准备型声明
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            //PrepareStatement.setString（int n，String），在声明的第n个？改为String
            statement.setString(1,account);
            statement.setString(2,password);
            //修改完后直接发送指令PrepareStatement.executeQuery（）
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                name = resultSet.getString("name");
                money = resultSet.getInt("money");
                u = new User(name,account,password,money);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }
}
