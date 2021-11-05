class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(){
        this(0, 0, 0);
    }

    public Time(int hour){
        this(hour, 0, 0);
    }

    public Time(int hour, int minute){
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second){
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("Hour must be 0-23");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("Minute must be 0-59");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("Second must be 0-59");

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time(Time time){
        this(time.getHour(), time.getMinute(), time.getSecond());
    }

    public void setTime(int hour, int minute, int second){
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("Hour must be 0-23");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("Minute must be 0-59");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("Second must be 0-59");

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("Hour must be 0-23");

        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("Minute must be 0-59");

        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("Second must be 0-59");

        this.second = second;
    }

    public String toUniversalString() {
        return  String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    public String toString() {
        return String.format("%d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }

    public String toMidnight(){
        return String.format("%02d seconds", ((getHour() * 3600) + getMinute() * 60 + getSecond()));
    }
}

public class Ch8Ex5{
    private static void displayTime(String header, Time t) {
        System.out.printf("%s%nUniversal time: %s" +
                "%nStandard time: %s" +
                "%nSeconds from midnight: %s%n", header,t.toUniversalString(), t.toString(), t.toMidnight());
    }
    public static void main(String[] args) {
        Time t1 = new Time();
        Time t2 = new Time(4);
        Time t3 = new Time(4, 20);
        Time t4 = new Time(4, 20, 20);
        Time t5 = new Time(t4);

        System.out.println("Constructed with:");
        displayTime("t1: all default arguments", t1);
        displayTime("t2: hour specified; default minute and second", t2);
        displayTime("t3: hour and minute specified; default second", t3);
        displayTime("t4: hour, minute and second specified", t4);
        displayTime("t5: Time2 object t4 specified", t5);

        try {
            Time t6 = new Time(27, 71, 90);
        }
        catch (IllegalArgumentException e){
            System.out.printf("Exception: %s%n", e.getMessage());
        }
    }
}
