public class Time {
    private int hour;
    private int minute;

    public Time (int hour, int minute)
    {
        this.hour = hour;
        this.minute = minute;
    }

    public void setHour(int hour)
    {
        this.hour = hour;
    }

    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString()
    {
        return String.format("%02d:%02d",hour,minute);
    }

    public void addMinutes(int minutes)
    {
        int time = this.hour * 60 + this.minute; // unify units
        time += minutes;
        this.hour = time / 60;
        this.minute = time %60;
    }
}
