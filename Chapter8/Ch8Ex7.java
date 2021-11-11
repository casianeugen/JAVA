class TimeTick {
    private int hour;
    private int minute;
    private int second;

    public TimeTick(){
        this(0, 0, 0);
    }

    public TimeTick(int hour){
        this(hour, 0, 0);
    }

    public TimeTick(int hour, int minute){
        this(hour, minute, 0);
    }

    public TimeTick(int hour, int minute, int second){
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

    public TimeTick(Time time){
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
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("Hour must be 0-23");

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

    public String toString() {
        return String.format("%d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }

    public void tick(){
        second++;
        if(getSecond() == 60){
            minute++;
            second = 0;
        }
        if(getMinute() == 60) {
            hour++;
            minute = 0;
        }
    }
}
public class Ch8Ex7 {
    private static void displayTime(TimeTick t) {
        System.out.printf("%n|%11s|", t.toString());
    }

    public static void main(String[] args) {
        TimeTick t1 = new TimeTick();
        TimeTick t2 = new TimeTick(7);
        TimeTick t3 = new TimeTick(7, 40);
        TimeTick t4 = new TimeTick(7, 59, 58);
        while (true) {
            try {
                t1.tick();
                Thread.sleep(1000);
                displayTime(t1);
            } catch (Exception ignored) {
            }
        }
    }
}
