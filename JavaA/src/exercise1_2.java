

import java.util.Scanner;

public class exercise1_2 {
    public static void main(String[] args) {
        System.out.print("Enter the number of seconds : ");
        Scanner scanner = new Scanner(System.in);
        int second = scanner.nextInt();
        int hour = second/3600;
        int minute = (second-3600*hour)/60;
        int s = second-3600*hour-60*minute;
        System.out.printf("The equvalent time is %d hours %d minutes %d seconds",hour,minute,s);
    }
}
