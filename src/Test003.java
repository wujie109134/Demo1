import java.util.Scanner;

public class Test003 {
    public static void main(String[] args) {
        /*
       Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println(name+age);
        */

        // 作业 控制台输入员工名字，年龄，薪水
        Scanner sn = new Scanner(System.in);
        System.out.println("员工名字：");
        // sn.next 遇到空格或者回车结束  sn.nextline 遇到回车结束，可以输入回车
        // String name1 = sn.next();
        String name1 = sn.nextLine();
        System.out.println("员工年龄：");
        int age1 = sn.nextInt();
        System.out.println("员工薪水：");
        double pay = sn.nextDouble();
        System.out.println("员工名字："+name1+" 员工年龄："+age1+" 员工薪水："+pay);
        Scanner  sr = new Scanner(System.in);



    }

}
