public class profit {
    public static void main(String[] args) {
        int i = 0;
        double base = 1.0e5;
        double balance = base;
        double rate = 1.795e-2 / 12;
        double profit = 0;
        int year = 10;
        double profitOfLastYear;
        while (i < year * 12)
        {
            profitOfLastYear = profit;
            balance += balance * rate;
            i++;
            profit = balance - base;
            System.out.printf("The profit of the first %d months: %f\n", i , profit);
            System.out.printf("The profit of the %d month: %f\n",i , profit - profitOfLastYear );
        }

    }
}
