import java.util.Scanner;

public class homework2_2 {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] cat = new int[length];
        int[] dog = new int[length];
        fillArray(cat, scanner);
        fillArray(dog, scanner);
        int query = scanner.nextInt();
        int index = query - 1;
        scanner.close();

        //whether data fixing is needed
        //fix the data
        if (cat [index] == -1)
        {
            cat [index] = fixData(cat, index);
        }
        if (dog [index] == -1)
        {
            dog [index] = fixData(dog, index);
        }

        //output
        if (dog[index] == -1 && cat[index] == -1)
        {
            System.out.println("ALL DATA LOST");
        }
        if (cat[index] != -1 && dog[index] == -1)
        {
            System.out.println("DOG DATA LOST");
        }
        if (cat[index] == -1 && dog[index] != -1)
        {
            System.out.println("CAT DATA LOST");
        }
        if (cat[index] != -1 && dog[index] != -1)
        {
            System.out.println(cat[index] + dog[index]);
        }
    }

    //fill array with input
    public static void fillArray(int[] array, Scanner scanner)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = scanner.nextInt();
        }
    }

    //fix data
    public static int fixData(int[] array, int index)
    {
        if (index == 0)
        {
            if (array[index + 1] != -1)
            {
                return (int) (0.8 * array[index + 1]);
            }
            else
            {
                return -1;
            }
        }
        if (index == array.length - 1)
        {
            if (array[index - 1] != -1)
            {
                return (int) (0.8 * array[index - 1]);
            }
            else
            {
                return -1;
            }
        }
        if (array[index + 1] == -1 || array[index - 1] == -1)
        {
            return -1;
        }
        else
        {
            return (int)(0.4 * array[index - 1] + 0.6 * array[index + 1]);
        }





    }
}



