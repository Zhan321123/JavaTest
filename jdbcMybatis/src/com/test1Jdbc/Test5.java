package com.test1Jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * 账号密码登录操作
 * 以及sql命令问题引入
 */
public class Test5 {
    public static void main(String[] args) {
        User user = find();
        System.out.println(user);
    }

    private static User find() {
        User u = null;
        String name;
        String account;
        String password;
        int money;

        Scanner scanner = new Scanner(System.in);
        System.out.println("account");
        account = scanner.nextLine();
        System.out.println("password");
        password = scanner.nextLine();

        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String mysqlPassword = "987654321asd";
        try (
                Connection connection = DriverManager.getConnection(url, user, mysqlPassword);
                Statement statement = connection.createStatement();
        ) {

            String sql = "select * from money where account = '"+account+"' and password = '"+password+"'";
            ResultSet resultSet = statement.executeQuery(sql);
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

class User{
    String name;
    String account;
    String password;
    int money;

    public User(String name, String account, String password, int money) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", money=" + money +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}