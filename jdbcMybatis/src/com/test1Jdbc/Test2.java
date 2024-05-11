package com.test1Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc操作数据库的异常处理和资源管理
 */
public class Test2 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        int i=0;

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String url = "jdbc:mysql://127.0.0.1:3306/test";
            String user = "root";
            String password = "987654321asd";
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            String sql = "update stus set name = 'fuck' where id = 9999";
            i = statement.executeUpdate(sql);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(i);


    }
}
