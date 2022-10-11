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
