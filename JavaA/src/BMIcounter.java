import java.util.Scanner;

public class BMIcounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your weight in kilograms");
        double weight = scanner.nextDouble();
        System.out.println("Your height in meters");
        double height = scanner.nextDouble();
        double BMI = weight / height /height;

        if (BMI < 18.5)
        {
            System.out.println("Undeweight");
        }
        else if (BMI < 24.9)
        {
            System.out.println("Optimum range");
        }
        else if (BMI < 29.9)
        {
            System.out.println("Overweight");
        }
        else if (BMI < 34.9)
        {
            System.out.println("Level 1 obesity");
        }
        else if (BMI < 39.9)
        {
            System.out.println("Level 2 obesity");
        }
        else
        {
            System.out.println("Level 3 obesity");
        }

        scanner.close();



    }
}
