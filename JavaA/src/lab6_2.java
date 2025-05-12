import java.util.Scanner;

public class lab6_2 {
    public static void main(String[] args) {
        User user1 = new User("Lucy");
        Scanner scanner = new Scanner(System.in);
        user1.setPassword("123456");
        user1.setMoney(1000);
        user1.introduce();
        user1.expense(2000,scanner);
        user1.expense(500,scanner);
        user1.income(1000);
        user1.introduce();
        scanner.close();

    }
}
