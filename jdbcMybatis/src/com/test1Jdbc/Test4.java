package com.test1Jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 前端与后端的分离
 * try的简易写法
 */
public class Test4 {
    public static void main(String[] args) {
        List<Study> list = find();
        for (Study s:list){
            System.out.println(s);
        }
    }

    private static List<Study> find() {

        List<Study> list = new ArrayList<>();
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "987654321asd";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
        ) {
            String sql = "select * from study";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String hireDate = resultSet.getString("hiredate");
                String name = resultSet.getString("name");
                String presentation = resultSet.getString("presentation");
                int number = resultSet.getInt("number");
                list.add(new Study(hireDate,name,presentation,number));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

class Study{
    String date;
    String name;
    String presentation;
    int number;

    public Study(String date, String name, String presentation, int number) {
        this.date = date;
        this.name = name;
        this.presentation = presentation;
        this.number = number;
    }

    @Override
    public String toString() {
        return "study{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", presentation='" + presentation + '\'' +
                ", number=" + number +
                '}';
    }
}
