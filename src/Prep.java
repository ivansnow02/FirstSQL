import java.sql.*;

public class Prep {
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
    public void pre(){//预处理
        Prep p = new Prep();
        con = p.getConnection();
        try{
            sql=con.prepareStatement("select * from tb_user where "+"id"+" = ?");
            sql.setInt(1,2);
            res = sql.executeQuery();
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
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
