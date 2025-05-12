import java.util.Scanner;

public class lab4_2 {
    public static void main(String[] arg) {
        //record appearance times
        int[] record = new int[101];

        //read the input
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            input = scanner.nextInt();
            record[input]++;
        } while (input != 0);
        scanner.close();

        //print the result
        for (int i = 1; i < 101; i++) {
            if (record[i] != 0) {
                System.out.printf("%d appears %d times\n", i, record[i]);
            }
        }
    }
}
