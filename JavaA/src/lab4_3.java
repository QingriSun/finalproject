import java.util.Scanner;

public class lab4_3 {
    public static void main(String[] args) {
        //input the limit
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the number of students: ");
        int sNum = scanner.nextInt();
        System.out.print("Please enter the number of courses: ");
        int cNum = scanner.nextInt();

        //store students' score
        int[][] score = new int[sNum + 1][cNum + 1];
        for(int i = 0;i < sNum; i++)
        {
            for (int j = 0; j < cNum; j++)
            {
                score[i][j] = scanner.nextInt();
                score[i][cNum] += score[i][j];
                score[sNum][j] += score[i][j];
            }
        }

        //average of each student
        for (int i = 0; i < sNum;i++)
        {
            score[i][cNum] /= cNum;
        }

        //average of each course
        for (int i = 0;i < cNum; i++)
        {
            score[sNum][i] /=sNum;
        }

        //output
        System.out.printf("          ");
        for (int i = 0; i < cNum; i++)
        {
            System.out.printf("%10s%d","Course",i+1);
        }
        System.out.printf("%10s\n","Adverage");

        for(int i = 0;i < sNum; i++)
        {
            System.out.printf("%10s%d","student",i+1);
            for (int j = 0; j < cNum; j++)
            {
                System.out.printf("%10d",score[i][j]);
            }
            System.out.printf("%10d\n",score[i][cNum]);
        }

        System.out.printf("%10s", "Average");
        for (int i = 0; i < cNum; i++)
        {
            System.out.printf("%10d",score[sNum][i]);
        }

    }
}
