package com.test1Jdbc;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 用PrepareStatement发送insert语句，比Statement的insert语句执行速度快
 * 打包多条语句批处理发送
 */
public class Test7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("name");
        String name = scanner.nextLine();
        System.out.println("account");
        String account = scanner.nextLine();
        System.out.println("password");
        String password = scanner.nextLine();

        User insert = insert(name, account, password);
        System.out.println(insert);

        int[] ints = insertBatch();
        System.out.println(Arrays.toString(ints));

    }

    private static User insert(String name, String account, String password) {
        User u = null;

        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String mysqlPassword = "987654321asd";
        String sql = "insert into money values(?,?,?,0)";
        try (
                Connection connection = DriverManager.getConnection(url, user, mysqlPassword);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, name);
            statement.setString(2, account);
            statement.setString(3, password);
            int i = statement.executeUpdate();
            if (i != 0) {
                u = new User(name, account, password, 0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    private static int[] insertBatch() {
        int[] ints = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String mysqlPassword = "987654321asd";
        String sql = "insert into money values(?,?,?,0)";
        try (
                Connection connection = DriverManager.getConnection(url, user, mysqlPassword);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            //每次打一个包PrepareStatement.addBatch()
            statement.setString(1, "gao");
            statement.setString(2, "4567");
            statement.setString(3, "8765");
            statement.addBatch();

            statement.setString(1, "zhan");
            statement.setString(2, "4567");
            statement.setString(3, "8765");
            statement.addBatch();

            statement.setString(1, "zhou");
            statement.setString(2, "4567");
            statement.setString(3, "8765");
            statement.addBatch();

            //最后发送这个包PrepareStatement.executeBatch（），返回每次修改数据行数的int[]
            ints = statement.executeBatch();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ints;
    }

}
