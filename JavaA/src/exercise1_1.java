

import java.util.Scanner;

public class exercise1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter the height of a rectangle : ");
        double height = scanner.nextDouble();
        System.out.println("Enter the weight of a rectangle : ");
        double weight = scanner.nextInt();
        double area=height * weight;
        double perimeter = (height+weight)*2;
        System.out.printf("area is %.2f\n",area);
        System.out.printf("The perimeter is %.2f",perimeter);



    }
}
