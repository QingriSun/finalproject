public abstract class Vehicle {
    protected String plateNumber;
    protected boolean isInside = false;
    protected Time arriveTime;

    public Vehicle(String plateNumber)
    {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %b",this.getClass().getSimpleName(), getPlateNumber(), getIsInside());
    }

    public String getPlateNumber()
    {
        return this.plateNumber;
    }

    public boolean getIsInside()
    {
        return isInside;
    }

    public Time getArriveTime()
    {
        return arriveTime;
    }

    public void setPlateNumber(String plateNumber)
    {
        this.plateNumber = plateNumber;
    }

    public void setInside(boolean isInside)
    {
        this.isInside = isInside;
    }

    public void setArriveTime(Time arriveTime)
    {
        //get an  arriveTime,meaning the vehicle is already in the lot
        setInside(true);
        this.arriveTime = arriveTime;
    }


    public abstract int calculateMoney(Time leaveTime);
}
