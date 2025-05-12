import java.util.Scanner;

public class homework2_3 {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int monNum = scanner.nextInt();
        int distNum = scanner.nextInt();
            //wrap the ture data with -1 ,to make the missing case equals to the non-existent
        int[][] data = new int[monNum + 2][distNum +2];
        for (int i = 0; i < data[0].length; i++)
        {
            data[0][i] = -1;
            data[data.length - 1][i] = -1;
        }
        for (int i = 1; i < data.length - 1; i++)
        {
            data[i][0] = -1;
            data[i][data[0].length -1] = -1;
        }
        for (int i = 1; i < monNum + 1; i++)
        {
            for (int j = 1; j < distNum + 1; j++)
            {
                data[i][j] = scanner.nextInt();
            }
        }
        int queryMon = scanner.nextInt();
        int queryDist = scanner.nextInt();
        scanner.close();

        //index[] = {left, right, up, down}
        double[] index = new double[4];
        int whichCase = judgeCase(data,queryMon,queryDist);
        indexS(index,whichCase);

        //repair the data
        if (whichCase == 0)
        {
            System.out.println(data[queryMon][queryDist]);
        }
        else {
            if (index[0] != -1) {
                data[queryMon][queryDist] = (int) (index[0] * data[queryMon][queryDist - 1] + index[1] * data[queryMon][queryDist + 1]
                        + index[2] * data[queryMon - 1][queryDist] + index[3] * data[queryMon + 1][queryDist]);
                System.out.println(data[queryMon][queryDist]);
            } else {
                System.out.println("DATA CANNOT BE REPAIRED");
            }
        }



    }

    //judge which case is the query in
    public static int judgeCase(int[][] data, int i, int j)
    {
        if (data[i][j] == -1)
        {
            if (data[i][j + 1] != -1 && data[i][j - 1] != -1 && data[i + 1][j] != -1 && data[i - 1][j] != -1)
            {
                return 1;//all available
            }
            if (data[i + 1][j] != -1 && data[i - 1][j] != -1)
            {
                if((data[i][j - 1] == -1 && data[i][j + 1] != -1) )
                {
                    return 2;//left missing
                }
                if((data[i][j - 1] != -1 && data[i][j + 1] == -1))
                {
                    return 3;//right
                }
            }
            if (data[i][j - 1] != -1 && data[i][j + 1] != -1)
            {
                if((data[i - 1][j] == -1 && data[i + 1][j] != -1))
                {
                    return 4;//up
                }
                if((data[i - 1][j] != -1 && data[i + 1][j] == -1))
                {
                    return 5;//down
                }
            }
            if((data[i - 1][j] == -1 && data[i + 1][j] != -1))
            {
               if  ((data[i][j - 1] == -1 && data[i][j + 1] != -1))
                {
                    return 6;//up & left
                }
               if ((data[i][j + 1] == -1 && data[i][j - 1] != -1))
               {
                   return 7;//up & right
               }
            }
            if ((data[i + 1][j] == -1 && data[i - 1][j] != -1))
            {
                if  ((data[i][j - 1] == -1 && data[i][j + 1] != -1))
                {
                    return 8;//down & left
                }
                if ((data[i][j + 1] == -1 && data[i][j - 1] != -1))
                {
                    return 9;//down & right
                }
            }
            if  ((data[i - 1][j] != -1 && data[i + 1][j] != -1))
            {
                if ((data[i][j + 1] == -1 && data[i][j - 1] == -1))
                {
                    return 10;//left & right
                }
            }
            if  ((data[i - 1][j] == -1 && data[i + 1][j] == -1))
            {
                if ((data[i][j + 1] != -1 && data[i][j - 1] != -1))
                {
                    return 11;//up & down
                }
            }
            return 12;//more than 2 missing data
        }
        else
        {
            return 0;
        }
    }

    //determine the index
    public static void indexS(double[] index, int returnCase)
    {
        switch(returnCase)
        {
            case 1://all available
                double[] value1 = {0.3, 0.3, 0.2, 0.2};
                System.arraycopy(value1,0,index,0,4);
                break;
            case 2://left
                double[] value20 = {0.0, 0.3, 0.35, 0.35};
                System.arraycopy(value20,0,index,0,4);
                break;
            case 3://right
                double[] value21 = {0.3, 0.0, 0.35, 0.35};
                System.arraycopy(value21,0,index,0,4);
                break;

            case 4://up
                double[] value30 = {0.4, 0.4, 0.0, 0.2};
                System.arraycopy(value30,0,index,0,4);
                break;
            case 5://down
                double[] value31 = {0.4, 0.4, 0.2, 0.0};
                System.arraycopy(value31,0,index,0,4);
                break;
            case 6://up & left
                double[] value40 = {0.0, 0.6, 0.0, 0.4};
                System.arraycopy(value40,0,index,0,4);
                break;
            case 7://up & right
                double[] value41 = {0.6, 0.0, 0.0, 0.4};
                System.arraycopy(value41,0,index,0,4);
                break;
            case 8://down & left
                double[] value42 = {0.0, 0.6, 0.4, 0.0};
                System.arraycopy(value42,0,index,0,4);
                break;
            case 9://down & right
                double[] value43 = {0.6, 0.0, 0.4, 0.0};
                System.arraycopy(value43,0,index,0,4);
                break;
            case 10://left & right
                double[] value5 = {0.0,0.0,0.5, 0.5};
                System.arraycopy(value5,0,index,0,4);
                break;
            case 11://up & down
                double[] value6 = {0.4,0.6,0.0, 0.0};
                System.arraycopy(value6,0,index,0,4);
                break;
            case 12://more than two missing number
                double[] value = {-1,-1,-1,-1};
                System.arraycopy(value,0,index,0,4);
                break;
        }
    }

}

