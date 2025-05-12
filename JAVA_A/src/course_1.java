import java.util.Scanner;

public class course_1 {
    public static void main(String[] args) {//用psvm加回车可以生成这一行
    /*    System.out.println("hello java programming");
        System.out.print("welcome \n");
        System.out.print("welcome\n");//sout
        int a = 100;
        System.out.println("a = " + a);//connected by "+"
        //Java缩径不影响执行

        //scanner (a class),creat a class first ,name it (scanner)
        Scanner scanner1 = new Scanner(System.in);
        int b = scanner1.nextInt();//give the input value to b
        char c = scanner1.next().charAt(0);//输入加号
        int d = scanner1.nextInt();//同一个方法里不能有重名
        char e = scanner1.next().charAt(0);
        System.out.println(b+d);

        Scanner scanner2 = new Scanner(System.in);
        String string = scanner2.next();
        System.out.println(string);*/

        int char_ = 'a';//将字符的ascll码赋给char_
        int Int = 2;
        double float_ = 2;
        System.out.println(Int/3);//整数除法掐头去尾
        System.out.println(float_/3);

        //两个值之间加号是加法符号，字符串之间是链接符
        //print(a + "+" + b + “=” + a+b）会导致第二个加号开始就变成了连接符了，所以这种用printf更加合适
        double m=2.13;
        double n = 2.19;

        System.out.printf("%.1f\n",m);
        System.out.printf("%.1f\n",m);//不给你四舍五入，直接掐头去尾


    }
}
