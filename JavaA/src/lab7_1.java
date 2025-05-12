import java.io.File;
import java.io.FileNotFoundException;
import java.text.Format;
import java.util.Formatter;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class lab7_1 {
    public static void main(String[] args) {
        File file = new File(".//src//textIn.txt");
        Scanner scanner;
        MyString mystring = new MyString();
        try
        {
            scanner = new Scanner(file);
            String string = scanner.next();
            mystring = new MyString(string);
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("file not found!");
        }

        Formatter fm;
        try
        {
            fm = new Formatter(".//src//textOut.txt");

            for (int i = mystring.length() - 1; i > 0; i--)
            {
                fm.format("%c",mystring.charAt(i));
            }
            fm.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not Found!");
        }
    }
}
