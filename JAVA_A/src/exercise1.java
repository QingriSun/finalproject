import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter the height of a rectangle : ");
        int height = scanner.nextInt();
        System.out.println("Enter the weight of a ractangle : ");
        int weight = scanner.nextInt();
        int area=height * weight;
        int perimeter = (height+weight)*2;
        System.out.printf("area is %。2d\n",area);
        System.out.printf("The perimeter is %.2d",perimeter);



}
    }

