package com.sql;

import java.sql.*;

public class Random {
    static Connection con;
    static Statement sql;
    static ResultSet res;

    public void rad() {
        con = Connect.getConnection();
        try {
            sql = con.createStatement();
            res = sql.executeQuery("SELECT * FROM tb_food AS t1 JOIN (SELECT ROUND(RAND()*(SELECT MAX(id) " +
                    "FROM tb_food)) AS id) AS t2 WHERE t1.id>=t2.id ORDER BY t1.id LIMIT 1;");
            System.out.println("查询成功！");
            res.next();
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
