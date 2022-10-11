package com.sql.search;

import java.sql.*;
import java.util.Scanner;

public class Prep {
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eating?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "254940Sr");
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void pre() {//预处理
        Prep p = new Prep();
        con = p.getConnection();
        Scanner input = new Scanner(System.in);
        System.out.println("请选择你要查询的表:");
        System.out.println("1、用户表");
        System.out.println("2、食物表");
        System.out.println("3、收藏表");
        int flag = input.nextInt();

        try {
            switch (flag) {
                case 1 -> {
                    System.out.println("请输入查询字段：(id,username,email,password)");
                    String s = input.next();
                    System.out.println("请输入查询内容：");
                    String word = input.next();
                    word = "'"+word+"'";
                    sql = con.prepareStatement("select * from tb_user where " + s + " = "+word);
                    res = sql.executeQuery();
                    while (res.next()) {
                        int id = res.getInt("id");
                        String username = res.getString("username");
                        String email = res.getString("email");
                        String password = res.getString("password");
                        System.out.println("查询成功！");
                        System.out.printf("编号：%s ", id);
                        System.out.printf("用户名：%s ", username);
                        System.out.printf("邮箱：%s ", email);
                        System.out.println("密码：" + password);
                    }
                }
                case 2 -> {
                    System.out.println("请输入查询字段：(id,name,canteen,floor)");
                    String s = input.next();
                    System.out.println("请输入查询内容：");
                    String word = input.next();
                    word = "'"+word+"'";
                    sql = con.prepareStatement("select * from tb_food where " + s + " = "+word);
//                    sql.setString(1, );
                    res = sql.executeQuery();
                    while (res.next()) {
                        int id = res.getInt("id");
                        String name = res.getString("name");
                        String canteen = res.getString("canteen");
                        int floor = res.getInt("floor");
                        System.out.printf("编号：%s ", id);
                        System.out.printf("食物名：%s ", name);
                        System.out.printf("食堂：%s ", canteen);
                        System.out.println("楼层：" + floor);
                    }
                }
                case 3 -> {
                    System.out.println("请输入查询字段：(food_id,user_id)");
                    String s = input.next();
                    System.out.println("请输入查询内容：");
                    String word = input.next();
                    word = "'"+word+"'";
                    sql = con.prepareStatement("select * from tb_favourite where " + s + " = "+word);
//                    sql.setString(1, );
                    res = sql.executeQuery();
                    while (res.next()) {
                        int user_id = res.getInt("user_id");
                        int food_id = res.getInt("food_id");
                        System.out.printf("食物编号：%s ", user_id);
                        System.out.println("用户编号：" + food_id);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
