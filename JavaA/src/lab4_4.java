import java.util.Scanner;

public class lab4_4 {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] block = new int[length];
        for (int i = 0; i < length; i++)
        {
            block[i] = scanner.nextInt();
        }
        scanner.close();;

        //find the tallest and fill water in the meanwhile
        int tallest = block[0];
        int tallestIndex = 0;
        int water = 0;
        int bottom = 0;
        for (int i = 1; i < block.length; i++)
        {
            if (block[i] >= tallest)
            {
                water += tallest * (i - tallestIndex -1);
                tallest = block[i];
                tallestIndex = i;
            }
            else
            {
                bottom += block[i];
            }
        }
        int tallestR = block[block.length - 1];
        int tallestRIndex = block.length - 1;
        for (int i = block.length -1 ; i >=tallestIndex; i-- )
        {
            if (block[i] >= tallestR)
            {
                water += tallestR * (tallestRIndex - i);
                tallestR = block[i];
                tallestRIndex = i;
            }
        }
        System.out.println(water - bottom);

    }
}
