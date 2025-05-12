import java.util.Scanner;
import java.util.Objects;

class User
{
    private String account;
    private String password;
    private double money;

    public void introduce()
    {
        System.out.printf("%s's account has a balance of %.2f dollar\n", account, money);
    }

    public void expense(double planExpense, Scanner scanner)
    {
        if (planExpense > money)
        {
            System.out.printf("Plan to expense %.2f dollar but not sufficient funds\n",planExpense);
        }
        else
        {
            System.out.printf("Plan to expense %.2f dollar\n",planExpense);
            System.out.println("Please put in your password: ");
            String userPW = scanner.next();
            if (Objects.equals(userPW, password))
            {
                money -= planExpense;
                System.out.printf("Expense %.2f dollar and balance %.2f dollar\n", planExpense, money - planExpense);
            }
            else
            {
                System.out.println("Wrong password\n");
            }
        }
    }

    public void income (double income)
    {
        money += income;
        System.out.printf("Got %.2f dollar for income, balance is %.2f dollar\n",income, money);
    }

    public void setAccount(String name)
    {
        account = name;
    }

    public String getAccount()
    {
        return account;
    }

    public void setMoney (double money)
    {
        this.money = money;
    }

    public double getMoney()
    {
        return money;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


    public User(String name)
    {
        account = name;
    }

    public User()
    {

    }
}
