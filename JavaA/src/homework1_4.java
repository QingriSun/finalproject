import java.util.Scanner;

public class homework1_4 {
    public static void main(String[] args) {
        //处理target
        Scanner scanner = new Scanner(System.in);

        //char 可以用==，string不行
        String type_t = scanner.next();
        char ent_t = type_t.charAt(0);
        double target = scanner.nextDouble();

        if (ent_t == 'F')
        {
            target = (target - 32) * 5 / 9;
        }
        else if (ent_t == 'K')
        {
            target = target - 273.15;
        }

        //输入共有多少组温度
        int count = scanner.nextInt();
        int i = 0;

        //初始化diff_old,提供对比的参照
        String type_1 = scanner.next();
        char ent_1 = type_1.charAt(0);
        double temp_1 = scanner.nextDouble();
        double diff_old;
        if (ent_1 == 'F')
        {
            temp_1 = (temp_1 - 32) * 5 / 9;
        }
        else if (ent_1 == 'K')
        {
            temp_1 = temp_1 - 273.15;
        }
        diff_old = temp_1 - target;
        if (diff_old < 0)
        {
            diff_old *= -1;
        }

        //输入剩下温度并选出最小的diff
        int result = 1;
        double diff_new ;
        double record = diff_old;
        do
        {
            String type = scanner.next();
            double temp = scanner.nextDouble();
            char ent = type.charAt(0);
            if (ent == 'F')
            {
                temp = (temp - 32) * 5 / 9;
            }
            else if (ent == 'K')
            {
                temp = temp - 273.15;
            }
            diff_new = temp - target;
            if (diff_new < 0)
            {
                diff_new *= -1;
            }
            if (diff_new < record)  //record写成diff_old了
            {
                record = diff_new;
                result = i + 2;
            }

            i++;
        }
        while (i < count - 1);

        System.out.print(result);
        scanner.close();

    }

}