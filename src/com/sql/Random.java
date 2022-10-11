package com.sql;

import java.sql.*;

public class Random {
    static Connection con;
    static Statement sql;
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

    public void rad() {
        Random r = new Random();
        con = r.getConnection();
        try {
            sql = con.createStatement();
            res = sql.executeQuery("select * from tb_food as t1 join (select round(rand()*（select max(id) from tb_food)) as id) as t2 where t1.id >= t2.id order by t1.id limit 1;");
            System.out.println("查询成功！");
            int id = res.getInt("id");
            String name = res.getString("name");
            String canteen = res.getString("canteen");
            int floor = res.getInt("floor");
            System.out.printf("编号：%s ", id);
            System.out.printf("食物名：%s ", name);
            System.out.printf("食堂：%s ", canteen);
            System.out.println("楼层：" + floor);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
