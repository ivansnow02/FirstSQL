import com.sql.Gradation;
import com.sql.Renewal;
import com.sql.Prep;

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
