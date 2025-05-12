import java.util.Scanner;
public class lab4_1 {
    public static void main(String[] args)
    {
        System.out.println("Enter the length of myLists");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        double[] myList1 = new double[length];
        for (int i = 0; i < length; i++)
        {
            myList1[i] = scanner.nextDouble();
        }
        scanner.close();;

        double[] myList2 = new double[length];
        for (int i = 0; i<length; i++)
        {
            myList2[i] = myList1[i];
        }

        for (int i = 0; i < length; i++)
        {
            myList1[i]= myList2[length-1-i];
        }

        double[] myList3 = new double[length];
        for (int i = 0; i < length; i++)
        {
            myList3[i] = myList1[i] + myList2[i];
        }

        System.out.print("myList1 ");
        for (int i = 0; i < length; i++)
        {
            System.out.print(myList1[i] + ",");
        }
        System.out.println();
        System.out.print("myList2 ");
        for (int i = 0; i < length; i++)
        {
            System.out.print(myList2[i] + ",");
        }
        System.out.println();
        System.out.print("myList3 ");
        for (int i = 0; i < length; i++)
        {
            System.out.print(myList3[i] + ",");
        }
        System.out.println();

    }
}
