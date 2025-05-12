import java.util.Scanner;

public class homework1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lower = scanner.nextInt();
        int upper = scanner.nextInt();
        scanner.close();

        int number = upper;
        int sum = 0;
        int divisor = number;
        int exist = 0;
        while (number >= lower)
        {
            while (divisor != 1)
            {
                divisor--;
                if (number % divisor == 0)
                {
                    sum +=divisor;
                }
            }
            if (number == sum)
            {
                exist = 1;
                System.out.println(number);
            }
            sum = 0;
            number--;
            divisor = number;
        }
        if (exist == 0)
        {
            System.out.println(-1);
        }

    }
}
