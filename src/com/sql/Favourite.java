package com.sql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Favourite {
    static Connection con;
    static PreparedStatement sql;

    public void fav() {
        con = Connect.getConnection();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户编号和食物编号");
        int user_id = input.nextInt();
        int food_id = input.nextInt();
        try {
            sql = con.prepareStatement("insert into tb_favourite ( food_id , user_id ) values ( ? , ? )");
            sql.setInt(1, food_id);
            sql.setInt(2, user_id);
            sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
