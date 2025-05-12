import java.util.ArrayList;

public class MyString {
    private ArrayList<Character> str;

    public MyString(String a) {
        str = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            str.add(a.charAt(i));
        }
    }

    public MyString() {
        //todo
        //new an empty str
        str = new ArrayList<>();
    }

    public void add(char x) {
        //todo
        //add x to the rear of str
        str.add(x);
    }

    public void set(int index, char x) {
        //todo
        //change the index-th character of str to x
        str.remove(index);
        str.add(index, x);
    }

    public char charAt(int index) {
        //todo
        return str.get(index);
    }

    public int length() {
        //todo
        return str.size();
    }

    public boolean equals(MyString b) {
        //todo
        for (int i = 0; i < str.size(); i++)
        {
            if (str.get(i) == b.str.get(i))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public char[] toCharArray() {
        //todo
        char[] charArray = new char[str.size()];
        for (int i = 0; i < str.size(); i++)
        {
            charArray[i] = str.get(i);
        }
        return charArray;
    }

    public void print() {
        for (int i = 0; i < str.size(); i++) {
            System.out.print(str.get(i));
        }
    }

}
