import java.util.Scanner;

public class homework3_2 {
    public static void main(String[] args) {
        // take input n,m,p,k
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int k = scanner.nextInt();

        //take element of matrix
        int[][] matrixA = makeMatrix(scanner, n, m);
        int[][] matrixB = makeMatrix(scanner, m, p);
        scanner.close();

        //operate
        int[][] matrixC = new int[n][p];
        for (int row = 0; row < n; row++)
        {
            for(int column = 0; column < p; column ++)
            {
                int sum = 0;
                for (int counter = 0; counter < m; counter++)
                {
                    if ((counter + 1) % k == 0)
                    {
                        sum += matrixA[row][counter] * matrixB[counter][column] * -1;
                    }
                    else
                    {
                        sum += matrixA[row][counter] * matrixB[counter][column];
                    }

                }
                matrixC[row][column] = sum;
                sum = 0;
            }
        }

        //print
        for (int column = 0; column < p; column++){
            for (int row = 0; row < n; row++)
            {
                System.out.printf("%d ",matrixC[row][column]);
            }
            System.out.printf("\n");
        }
    }

    public static int[][] makeMatrix(Scanner scanner, int i, int j)
    {
        int[][] matrix = new int[i][j];
        for (int row = 0; row < i; row++)
        {
            for (int column = 0; column < j; column++)
            {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
