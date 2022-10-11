package com.sql;

import java.sql.*;
import java.util.Scanner;

public class Renewal {
    static Connection con;
    static PreparedStatement sql;
    public void ren(int i) {
        con = Connect.getConnection();
        Scanner input = new Scanner(System.in);
        System.out.println("请选择你要操作的表:");
        System.out.println("1、用户表");
        System.out.println("2、食物表");
        int flag = input.nextInt();
        try {
            switch (flag) {
                case 1 -> {
                    try {
                        switch (i) {
                            case 1 -> {
                                System.out.println("请输入添加内容(username,email,password)：");
                                String s1 = input.next();
                                String s2 = input.next();
                                String s3 = input.next();
                                sql = con.prepareStatement("insert into tb_user (username,email,password) value (?,?,?)");
                                sql.setString(1, s1);
                                sql.setString(2, s2);
                                sql.setString(3, s3);
                                sql.executeUpdate();//增加

                            }
                            case 2 -> {
                                System.out.println("请输入修改id：");
                                int id = input.nextInt();
                                System.out.println("请输入要修改的字段(username,email,password)：");
                                String word = input.next();
                                System.out.println("请输入要修改的内容：");
                                String s = input.next();
                                sql = con.prepareStatement("update tb_user set "+word+" = "+s+" where id = ?");
                                sql.setInt(1, id);
                                sql.executeUpdate();

                                //修改
                            }
                            case 3 -> {//删除
                                System.out.println("请输入删除的id：");
                                int id = input.nextInt();
                                sql.executeUpdate("delete from tb_user where id = ?");
                                sql.setInt(1,id);
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    try {
                        switch (i) {
                            case 1 -> {
                                System.out.println("请输入添加内容(name,canteen,floor)：");
                                String s1 = input.next();
                                String s2 = input.next();
                                String s3 = input.next();
                                sql = con.prepareStatement("insert into tb_food (name,canteen,floor) value (?,?,?)");
                                sql.setString(1, s1);
                                sql.setString(2, s2);
                                sql.setString(3, s3);
                                sql.executeUpdate();//增加

                            }
                            case 2 -> {
                                System.out.println("请输入修改id：");
                                int id = input.nextInt();
                                System.out.println("请输入要修改的字段(name,canteen,floor)：");
                                String word = input.next();
                                System.out.println("请输入要修改的内容：");
                                String s = input.next();
                                sql = con.prepareStatement("update tb_food set "+word+" = '"+s+"' where id = ?");
                                sql.setInt(1, id);
                                sql.executeUpdate();

                                //修改
                            }
                            case 3 -> {//删除
                                System.out.println("请输入删除的id：");
                                int id = input.nextInt();
                                sql.executeUpdate("delete from tb_food where id = ?");
                                sql.setInt(1,id);
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
