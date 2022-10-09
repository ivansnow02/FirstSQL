import java.sql.*;

public class Renewal {
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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first_database?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "254940Sr");
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public void ren(){
        Renewal r = new Renewal();
        con = r.getConnection();
        try{
            sql = con.prepareStatement("select * from tb_user");
            res = sql.executeQuery();
            System.out.println("执行操作前数据：");
            while(res.next()){
                String id = res.getString("id");
                String name = res.getString("name");
                String age = res.getString("age");
                String gender = res.getString("gender");
                System.out.printf("编号：%s ", id);
                System.out.printf("姓名：%s ", name);
                System.out.printf("年龄：%s ", age);
                System.out.println("性别：" + gender);
            }
            sql = con.prepareStatement("insert into tb_user value (?,?,?,?)");
            sql.setInt(1,4);
            sql.setString(2,"菜");
            sql.setInt(3,18);
            sql.setString(4,"男");
            sql.executeUpdate();
            //增加
            sql=con.prepareStatement("update tb_user set age = ? where id = 1");
            sql.setInt(1,18);
            sql.executeUpdate();
            //修改
//            sql.executeUpdate("delete from tb_user where id = 4");
//            sql.executeUpdate();
            //删除
            sql = con.prepareStatement("select * from tb_user");
            res = sql.executeQuery();
            System.out.println("执行操作后数据：");
            while(res.next()){
                String id = res.getString("id");
                String name = res.getString("name");
                String age = res.getString("age");
                String gender = res.getString("gender");
                System.out.printf("编号：%s ", id);
                System.out.printf("姓名：%s ", name);
                System.out.printf("年龄：%s ", age);
                System.out.println("性别：" + gender);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
