import java.util.Scanner;

public class homework3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read n, m
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // read matrix
        char[][] matrix = new char[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }

        // read the old string and the new string
        String old = scanner.next();
        String replace = scanner.next();
        scanner.close();

        // judge if the string longer than the entire matrix
        int MatrixLength = n * m;
        int StringLength = replace.length();
        boolean CanBeRestore = true;
        if (MatrixLength < StringLength)
        {
            CanBeRestore = false;
        }

        // traverse through the matrix, and form a one-dimension array
        char[] OneLineMatrix = new char[n * m];
        TwoDToOneD(matrix, OneLineMatrix);


        //restore
        if (CanBeRestore)
        {
            char c0 = old.charAt(0);
            for (int i = 0; i < OneLineMatrix.length; i++)
            {
                if (OneLineMatrix[i] == c0)
                {
                    int j = i + 1;
                    for (; j < m * n && j - i <old.length(); j++)
                    {
                        if (OneLineMatrix[j] != old.charAt(j - i))
                        {
                            break;
                        }
                    }
                    if (j - i == old.length())
                    {
                        for (j = i; j < i + old.length(); j++)
                        {
                            OneLineMatrix[j] = replace.charAt(j - i);
                        }
                        i = j - 1; // i will increase by one at the end of this loop
                    }
                }
            }
        }

        // transpose the restored OneDMatrix back to the TweDMatrix
        OneDToTwoD(OneLineMatrix,matrix);

        //print the restored matrix
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.printf("%c ",matrix[i][j]);
            }
            System.out.print("\n");
        }
    }
    public static void TwoDToOneD (char[][] TwoDMatrix, char[] OneDMatrix)
    {
        int n = TwoDMatrix.length;
        int m = TwoDMatrix[0].length;

        int RBound = m - 1;
        int LBound = 0;
        int UBound = 0;
        int DBound = n - 1;
        int rowIndex = 0;
        int columnIndex = -1; // 因为要从这里开始顺时针旋转
        int Index = 0;
        while (Index != m * n )
        {
            if (columnIndex == LBound - 1 && rowIndex == UBound)
            {
                columnIndex++;
                for (; columnIndex <= RBound; columnIndex++)
                {
                    OneDMatrix[Index] = TwoDMatrix[rowIndex][columnIndex];
                    Index++; // 平衡掉最后一个循环使columnIndex增加的副作用
                }
                UBound++;
                columnIndex = RBound;
                continue;
            }
            if (rowIndex == UBound - 1 && columnIndex ==RBound)
            {
                rowIndex++;
                for (;rowIndex <= DBound; rowIndex++)
                {
                    OneDMatrix[Index] = TwoDMatrix[rowIndex][columnIndex];
                    Index++;
                }
                RBound--;
                rowIndex = DBound;
                continue;
            }
            if (columnIndex == RBound + 1 && rowIndex == DBound)
            {
                columnIndex--;
                for ( ;columnIndex >= LBound; columnIndex--)
                {
                    OneDMatrix[Index] = TwoDMatrix[rowIndex][columnIndex];
                    Index++;
                }
                DBound--;
                columnIndex = LBound;
                continue;
            }
            if (rowIndex == DBound +1 && columnIndex == LBound)
            {
                rowIndex--;
                for (;rowIndex >= UBound; rowIndex--)
                {
                    OneDMatrix[Index] = TwoDMatrix[rowIndex][columnIndex];
                    Index++;
                }
                LBound++;
                rowIndex = UBound;
                continue;
            }
        }
    }

    public static void OneDToTwoD(char[] OneDMatrix, char[][] TwoDMatrix)    {
        int n = TwoDMatrix.length;
        int m = TwoDMatrix[0].length;

        int RBound = m - 1;
        int LBound = 0;
        int UBound = 0;
        int DBound = n - 1;
        int rowIndex = 0;
        int columnIndex = -1;
        int Index = 0;
        while (Index != m * n )
        {
            if (columnIndex == LBound - 1 && rowIndex == UBound)
            {
                columnIndex++;
                for (; columnIndex <= RBound; columnIndex++)
                {
                    TwoDMatrix[rowIndex][columnIndex] = OneDMatrix[Index];
                    Index++;
                }
                UBound++;
                columnIndex = RBound;
                continue;
            }
            if (rowIndex == UBound - 1 && columnIndex == RBound)
            {
                rowIndex++;
                for (;rowIndex <= DBound; rowIndex++)
                {
                    TwoDMatrix[rowIndex][columnIndex] = OneDMatrix[Index] ;
                    Index++;
                }
                RBound--;
                rowIndex = DBound;
                continue;
            }
            if (columnIndex == RBound + 1 && rowIndex == DBound)
            {
                columnIndex--;
                for ( ;columnIndex >= LBound; columnIndex--)
                {
                    TwoDMatrix[rowIndex][columnIndex] = OneDMatrix[Index];
                    Index++;
                }
                DBound--;
                columnIndex = LBound;
                continue;
            }
            if (rowIndex == DBound + 1 && columnIndex == LBound)
            {
                rowIndex--;
                for (;rowIndex >= UBound ; rowIndex--)
                {
                    TwoDMatrix[rowIndex][columnIndex] = OneDMatrix[Index];
                    Index++;
                }
                LBound++;
                rowIndex = UBound;
            }
        }
    }

}
