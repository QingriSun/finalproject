import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        FileWriter fw;
        try
        {
            fw = new FileWriter("C://Users//sqr//Desktop//test5.txt",true); // true代表开启追加模式
            fw.write("I wrote this line using a java programme\n");
            fw.close();
        }
        catch(IOException e)
        {
            System.out.println("there was an error writing to the file");
        }

        Scanner scanner;
        File file = new File("C://Users//sqr//Desktop//test5.txt");
        try
        {
            scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find the file.");
        }
    }
}
