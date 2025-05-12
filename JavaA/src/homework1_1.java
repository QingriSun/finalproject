import java.util.Scanner;

public class homework1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int term_number = scanner.nextInt();
        while (term_number > 0)
        {
            term_number--;
            int term = scanner.nextInt();
            System.out.println(term % 10);
        }
        scanner.close();
    }
}
