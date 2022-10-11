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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eating?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "254940Sr");
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public void ren(int i ){
        Renewal r = new Renewal();
        con = r.getConnection();
        try{
            sql = con.prepareStatement("select * from tb_user");
            res = sql.executeQuery();
            System.out.println("执行操作前数据：");
            while(res.next()){
                int id = res.getInt("id");
                String username = res.getString("username");
                String email = res.getString("email");
                String password = res.getString("password");
                System.out.println("查询成功！");
                System.out.printf("编号：%s ", id);
                System.out.printf("用户名：%s ", username);
                System.out.printf("邮箱：%s ", email);
                System.out.println("密码：" + password);
            }
            switch (i) {
                case 1 -> {
                    sql = con.prepareStatement("insert into tb_user (username,email,password) value (?,?,?)");
                    sql.setString(1, "菜神");
                    sql.setString(2, "cai@email.com");
                    sql.setString(3, "123456");
                    sql.executeUpdate();//增加

                }
                case 2 -> {
                    sql = con.prepareStatement("update tb_user set password = ? where id = 1");
                    sql.setInt(1, 1998);
                    sql.executeUpdate();

                    //修改
                }
                case 3 -> //删除
                        sql.executeUpdate("delete from tb_user where id = 4");

            }
//            sql.executeUpdate();
            sql = con.prepareStatement("select * from tb_user");
            res = sql.executeQuery();
            System.out.println("执行操作后数据：");
            while(res.next()){
                int id = res.getInt("id");
                String username = res.getString("username");
                String email = res.getString("email");
                String password = res.getString("password");
                System.out.printf("编号：%s ", id);
                System.out.printf("用户名：%s ", username);
                System.out.printf("邮箱：%s ", email);
                System.out.println("密码：" + password);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
