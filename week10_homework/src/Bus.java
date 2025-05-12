public class Bus extends Vehicle{
    private final int maxPrice = 100;
    private final int incrementPrice = 15;
    private int previouParkingTime = 0;
    private int currentParkingTime = 0;
    private int fee = 0;

    public void setPreviouParkingTime(int previouParkingTime) {
        this.previouParkingTime = previouParkingTime;
    }

    public void setCurrentParkingTime(int currentParkingTime) {
        this.currentParkingTime = currentParkingTime;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getPreviouParkingTime() {
        return previouParkingTime;
    }

    public int getCurrentParkingTime() {
        return currentParkingTime;
    }

    public int getFee() {
        return fee;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getIncrementPrice() {
        return incrementPrice;
    }

    public Bus(String plateNumber)
    {
        super(plateNumber);
    }

    public int toMinute(Time leaveTime)
    {
        return leaveTime.getHour() * 60 + leaveTime.getMinute() - getArriveTime().getHour() * 60 - getArriveTime().getMinute();
    }

    // only involve the situation where minute is not less than 30
    public int netFeeEachTime(int minute)
    {
        if (minute < 30)
        {
            return 0;
        }
        else if (minute < 60)
        {
            return getIncrementPrice();
        }
        else if (minute / 60 < 6)
        {
            return (minute / 60 + 1) * getIncrementPrice();
        }
        else
        {
            return getMaxPrice();
        }
    }

    @Override
    public int calculateMoney(Time leaveTime) {
        // case 1 not in the garage
        if (!getIsInside())
        {
            return 0;
        }

        int thisTime = toMinute(leaveTime);

        // case2 too little time to pay
        if (thisTime < 30)
        {
            setArriveTime(null);
            setInside(false);
            return 0;
        }

        // case3 the fee this time is equal to the difference
        setCurrentParkingTime(getPreviouParkingTime() + thisTime);
        int previousPrice = netFeeEachTime(getPreviouParkingTime());
        int currentPrice = netFeeEachTime(getCurrentParkingTime());

         // the total fee reach the maxPrice
        if (getFee() + currentPrice - previousPrice > getMaxPrice())
        {
            setFee(getMaxPrice());
            setInside(false);
            return getMaxPrice() - previousPrice;
        }

        // the total fee does not reach the maxPrice
        // restore and change parameters
        setInside(false);
        setPreviouParkingTime(getPreviouParkingTime() + thisTime);
        return currentPrice - previousPrice;
    }
}
