public class Car extends Vehicle{
    private final int startTimePrice = 15;
    private final int maxPrice = 60;
    //record previous parking time, in which the latest parking time is exclude
    private int previousParkingTime = 0;
    //include the latest invalid parking time
    private int currentParkingTime = 0;
    private int fee = 0;

    public void setPreviousParkingTime(int previousParkingTime) {
        this.previousParkingTime = previousParkingTime;
    }

    public void setCurrentParkingTime(int currentParkingTime) {
        this.currentParkingTime = currentParkingTime;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getPreviousParkingTime() {
        return previousParkingTime;
    }

    public int getCurrentParkingTime() {
        return currentParkingTime;
    }

    public int getFee() {
        return fee;
    }

    public int getStartTimePrice() {
        return startTimePrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    //constructor
    public Car(String plateNumber)
    {
        super(plateNumber);
    }

    //calculate how many minutes does the latest parking use
    public int toMinute(Time leaveTime)
    {
        return leaveTime.getHour() * 60 + leaveTime.getMinute() - getArriveTime().getHour() * 60 - getArriveTime().getMinute();
    }

    //take the duration of the last parking time as input
    public int netFeeEachTIme(int minute)
    {
        if (minute < 30)
        {
            return 0;
        }
        //notice: the situation where the max price is reached is put into consideration in calculateMoney
        else if (minute < 600)
        {
            return getStartTimePrice() + minute / 60 * 5;
        }
        else
        {
            return getMaxPrice();
        }
    }

    public int calculateMoney(Time leaveTime) {
        // if the car is not in the garage
        if (!getIsInside())
        {
            return 0;
        }

        //before the latest parking
        //record the duration of the nth time the car park
        int thisTime = toMinute(leaveTime);

        // if the parking time is less than 30min, just pretend it never arrive
        if (thisTime < 30)
        {
            // out of the lot and had not changed anything
            setArriveTime(null);
            setInside(false);
            return 0;
        }

        setCurrentParkingTime(getPreviousParkingTime() + thisTime);

        // calculate the current fee and the previous fee
        int currentParkingFee = netFeeEachTIme(getCurrentParkingTime());
        int previousParkingFee = netFeeEachTIme(getPreviousParkingTime());

        // record how much money have already been paid
        setFee(getFee() + (currentParkingFee - previousParkingFee));

        //judge if the maxPrice is reached
        if (getFee() > getMaxPrice())
        {
            setFee(getMaxPrice());
            return getFee() - previousParkingFee;
        }

        // the car driven out from the lot
        setPreviousParkingTime(getPreviousParkingTime() + thisTime);
        setArriveTime(null);
        setInside(false);

        return currentParkingFee - previousParkingFee;
    }
}
