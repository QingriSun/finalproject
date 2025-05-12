import java.util.Scanner;

public class lab6_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("number of user: ");
        int num = scanner.nextInt();
        User[] users = new User[num];
        String name;
        double balance;
        for (int i = 0; i < num; i++)
        {
            users[i] = new User();
            System.out.printf("Please type in the account name for user %d: ", i);
            name = scanner.next();
            users[i].setAccount(name);

            System.out.printf("Please type in the balance of the user %d: ",i);
            balance = scanner.nextDouble();
            users[i].setMoney(balance);
        }

        for (int i = 0; i < num; i++)
        {
            System.out.printf("%s's account has a banlance of %.2f dollar\n",users[i].getAccount(),users[i].getMoney());
        }
    }
}
