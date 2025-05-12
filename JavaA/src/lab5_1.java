import java.util.Scanner;

public class lab5_1 {

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
          //wrap the ture data
        int[][] data = new int[row + 2][column + 2];
//        for (int i = 0; i < column + 2; i++)
//        {
//            data[0][i] = 0;
//        }
//        for (int i = 0; i < column + 2; i++)
//        {
//            data[row + 1][i] = 0;
//        }
        for ( int i = 1; i < row + 1; i++)
        {
//            data[i][0] = 0;
            for (int j = 1; j < column + 1; j++)
            {
                data[i][j] = scanner.nextInt();
            }
//            data[i][column + 1] = 0;
        }
        scanner.close();

        int bingo = 0;
        for (int i = 1; i < row + 1; i++)
        {
            for (int j = 1; j < column + 1; j++)
            {
                if (check(data,i,j))
                {
                    bingo++;
                }
            }
        }

        System.out.printf("There is %d BIngo box", bingo);

    }
    public static boolean check(int[][] data,int i, int j)
    {
        if (data[i][j] == 0 && data[i - 1][j] == 1 && data[i + 1][j] == 1 && data[i][j + 1] == 1 && data[i][j - 1] == 1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
