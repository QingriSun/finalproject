import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.pow;

public class homework3_1 {
    //get input
    private static String plaintext;

    // make the variable len available to my method
    private static int len;

    //build places to store separated num-string and letter-sum
    private static ArrayList<String> number = new ArrayList<>();
    private static ArrayList<String> letter = new ArrayList<>();

    public static void main(String[] args) {
        //get input
        Scanner scanner = new Scanner(System.in);
        plaintext = scanner.next();
        len = plaintext.length();
        scanner.close();

        //separate numbers and letters
        separate(plaintext);

        // store all the processed number in the sum array
        double[] numsum = new double[number.size()];
    for ( int i = 0; i < number.size(); i++)
    {
        String numstr = number.get(i);
        int numGroupLen = numstr.length();
        char[] numGroup = numstr.toCharArray();
        if (numstr.length() % 2 == 1)
        {
            int middleIndex = numGroupLen / 2;
            if (middleIndex == 0)
            {
                numsum[i] = 0;
            }
            else
            {
                for (int j = 0; j < middleIndex; j++)
                {
                    numsum[i] += (numGroup[j] - '0') * pow(10,j);
                }
                for (int j = numGroupLen - 1; j > middleIndex; j--)
                {
                    numsum[i] += (numGroup[j] - '0') * pow(10,j - 1);
                }
            }

        }
        else
        {
            for (int j = 0; j < numstr.length(); j++)
            {
                numsum[i] += (numGroup[j] - '0') * pow(10,j);
            }

        }
    }

        //store the ASCII sum in the sum array
        double[] ascsum = new double[letter.size()];
        for ( int i = 0; i < letter.size(); i++)
        {
            String lestr = letter.get(i);
            int leGroupLen = lestr.length();
            char[] leGroup = lestr.toCharArray();
            if (lestr.length() % 2 == 1)
            {
                int middleIndex = leGroupLen / 2;
                if (middleIndex == 0)
                {
                    ascsum[i] = 0;
                }
                else
                {
                    for (int j = 0; j < middleIndex; j++)
                    {
                        ascsum[i] += leGroup[j];
                    }
                    for (int j = leGroupLen - 1; j > middleIndex; j--)
                    {
                        ascsum[i] += leGroup[j];
                    }
                }
            }
            else
            {
                for (int j = 0; j < lestr.length(); j++)
                {
                    ascsum[i] += leGroup[j];
                }
            }
        }

        //sum and output

        double sum = 0;
        for (int i = 0; i < numsum.length; i++)
        {
            sum += numsum[i];
        }
        for (int i = 0; i < ascsum.length; i++)
        {
            sum += ascsum[i];
        }

        System.out.println((int)sum);
    }

    //return an arraylist containing many strings
    public static void separate (String plaintext)
    {
        int beginIndex = 0;
        int endIndex;
        for (int i = 0; i < len; i++)
        {
            if (isNum(plaintext.charAt(i)))
            {
                for (int j = beginIndex; j < len; j++)
                {
                    if (j == len - 1 && isNum(plaintext.charAt(j)))
                    {
                        endIndex = len - 1;
                        number.add(plaintext.substring(beginIndex, endIndex + 1));
                        i = j;
                        break;
                    }
                    else if (isNum(plaintext.charAt(j)))
                    {
                        continue;
                    }
                    i = j - 1;
                    endIndex = j;
                    number.add(plaintext.substring(beginIndex, endIndex));
                    beginIndex = j;

                    break;
                }
            }
            if (isLetter(plaintext.charAt(i)))
            {
                for (int j = beginIndex; j < len; j++)
                {
                    if (j == len - 1 && isLetter(plaintext.charAt(j)))
                    {
                        endIndex = len - 1;
                        letter.add(plaintext.substring(beginIndex, endIndex + 1));
                        i = j;
                        break;
                    }
                    if (isLetter(plaintext.charAt(j)))
                    {
                        continue;
                    }
                    i = j - 1;
                    endIndex = j;
                    letter.add(plaintext.substring(beginIndex, endIndex));
                    beginIndex = j;

                    break;
                }

            }
        }
    }

    public  static boolean isNum(char i)
    {
        int zeroCode = 48;
        int nineCode = 57;
        return i <= nineCode && i >= zeroCode; // simplified by idea
    }

    public static boolean isLetter(char i)
    {
        int ACode = 65;
        int ZCode = 90;
        int aCode = 97;
        int zCode = 122;
        return (i >= ACode && i <= ZCode) || (i >= aCode && i <= zCode);
    }

    public static boolean isOdd (ArrayList<String> arrl) {
        int length;
        length = arrl.size();
        if (length % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }


}


