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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
