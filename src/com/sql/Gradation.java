package com.sql;

import java.sql.*;
import java.util.Scanner;

public class Gradation {//顺序查询
    static Connection con;
    static Statement sql;
    static ResultSet res;

    public void gra() {
        con = Connect.getConnection();
        Scanner input = new Scanner(System.in);
        System.out.println("请选择你要查询的表:");
        System.out.println("1、用户表");
        System.out.println("2、食物表");
        System.out.println("3、收藏表");

        int flag = input.nextInt();

        try {
            switch (flag) {
                case 1 -> {
                    sql = con.createStatement();
                    res = sql.executeQuery("select * from tb_user");
                    System.out.println("查询成功！");
                    while (res.next()) {
                        int id = res.getInt("id");
                        String username = res.getString("username");
                        String email = res.getString("email");
                        String password = res.getString("password");
                        System.out.printf("编号：%s ", id);
                        System.out.printf("用户名：%s ", username);
                        System.out.printf("邮箱：%s ", email);
                        System.out.println("密码：" + password);
                    }

                }
                case 2 -> {
                    sql = con.createStatement();
                    res = sql.executeQuery("select * from tb_food");
                    System.out.println("查询成功！");
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
                    sql = con.createStatement();
                    res = sql.executeQuery("select * from tb_favourite");
                    System.out.println("查询成功！");
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
