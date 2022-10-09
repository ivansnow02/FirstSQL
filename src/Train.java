import java.sql.*;

public class Train {//模糊查询
    static Connection con;
    static Statement sql;
    static ResultSet res;

    public void tra() {
        Train t = new Train();
        con = t.getConnection();
        try {
            sql = con.createStatement();
            res = sql.executeQuery("select * from tb_user where " + "name" + " like " + "'球%'");
            while (res.next()) {
                String id = res.getString("id");
                String name = res.getString("name");
                String age = res.getString("age");
                String gender = res.getString("gender");
                System.out.println("查询成功！");
                System.out.printf("编号：%s ", id);
                System.out.printf("姓名：%s ", name);
                System.out.printf("年龄：%s ", age);
                System.out.println("性别：" + gender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first_database?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "254940Sr");
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}