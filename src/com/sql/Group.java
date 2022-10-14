package com.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Group {
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;

    public void gro() {
        con = Connect.getConnection();
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("请输入查询的食堂和楼层：");
            String scanteen = input.next();
            String sfloor = input.next();
            sql = con.prepareStatement("SELECT * FROM tb_food WHERE canteen = ? AND floor = ?");
            sql.setString(1, scanteen);
            sql.setString(2, sfloor);
            res = sql.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
