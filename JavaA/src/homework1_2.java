import java.util.Scanner;

public class homework1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int judge = scanner.nextInt();

        int digit3 = number % 10;
        number /= 10;
        int digit2 = number % 10;
        int digit1 = number / 10;

        int temp;
        if (digit3 > digit2) {
            temp = digit2;
            digit2 = digit3;
            digit3 = temp;
        }
        if (digit2 > digit1) {
            temp = digit1;
            digit1 = digit2;
            digit2 = temp;
        }
        if (digit3 > digit2) {
            temp = digit2;
            digit2 = digit3;
            digit3 = temp;
        }
        if (judge == 0) {
            System.out.printf("%d%d%d\n", digit1, digit2, digit3);
        }
        if (judge == 1) {
            System.out.printf("%d%d%d\n", digit3, digit2, digit1);
        }
    }
}
