import com.sql.*;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String is_exit;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("请选择您的操作：");
            System.out.println("1、查询");
            System.out.println("2、搜索");
            System.out.println("3、添加、修改、删除");
            System.out.println("4、随机取出一个食物");
            System.out.println("5、收藏");
            System.out.println("6、筛选查询");
            try {
                int flag = input.nextInt();
                switch (flag) {
                    case 1 -> {
                        Gradation gradation = new Gradation();
                        gradation.gra();
                    }
                    case 2 -> {
                        Prep prep = new Prep();
                        prep.pre();
                    }
                    case 3 -> {
                        System.out.println("请选择操作：");
                        System.out.println("1、添加");
                        System.out.println("2、修改");
                        System.out.println("3、删除");
                        int choice = input.nextInt();
                        Renewal renewal = new Renewal();
                        renewal.ren(choice);
                    }
                    case 4 -> {
                        Random random = new Random();
                        random.rad();
                    }
                    case 5 -> {
                        Favourite favourite = new Favourite();
                        favourite.fav();
                    }
                    case 6 -> {
                        Group group = new Group();
                        group.gro();
                    }
                }
            } catch (InputMismatchException e1) {
                System.out.println("请输入指定的数字！");
                e1.printStackTrace();
            } finally {
                System.out.println("是否继续？ 按y继续，任意键退出");
                is_exit = input.next();
            }
        } while (is_exit.equals("y"));
    }
}
