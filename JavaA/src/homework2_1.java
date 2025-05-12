import java.util.Scanner;
public class homework2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int disNum = scanner.nextInt();

        int[] cat = new int[disNum];
        for (int i = 0; i < disNum; i++)
        {
            cat[i] = scanner.nextInt();
        }

        int[] dog = new int[disNum];
        for (int i = 0; i < disNum; i++)
        {
            dog[i] = scanner.nextInt();
        }

        int consult = scanner.nextInt();
        int missNum = 0;
        if (cat[consult-1] == -1)
        {
            missNum++;
        }
        if(dog[consult-1] == -1)
        {
            missNum++;
        }
        System.out.println(missNum);
    }
}
