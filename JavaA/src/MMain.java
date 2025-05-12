import java.util.ArrayList;

public class MMain {
    public static void main(String[] args) {
        MyString a = new MyString("abc");
        MyString b = new MyString();
        b.add('a');
        b.add('c');
        b.add('c');
        if (a.equals(b)) System.out.println("They are same.");
        else System.out.println("They are different.");
        b.set(1, 'b');
        if (a.equals(b)) System.out.println("They are same.");
        else System.out.println("They are different.");
        char[] arr = a.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            System.out.print(arr[i]);
        }
        a.print();
    }
}