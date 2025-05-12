public class Date {
    private int year;
    private int month;
    private int day;
    public Date(int theMonth, int theDay, int theYear) {
        month = checkMonth(theMonth);
        year = theYear;
        day = theDay;
        System.out.printf("Date object constructor for date %s\n", this);
    }

    private int checkMonth(int testMonth) {
        if (testMonth > 0 && testMonth <= 12) return testMonth;
        else {
            System.out.printf("Invalid month (%d), set to 1", testMonth);
            return 1;
        }
    }
}
