class dateAndTime {
    private int hour;
    private int minute;
    private int second;
    private int month;
    private int day;
    private int year;

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public dateAndTime(int hour, int minute, int second, int day, int month, int year) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("Hour must be 0-23");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("Minute must be 0-59");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("Second must be 0-59");
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");
        if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        if (month == 2 || day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d %02d/%02d/%04d", getHour(), getMinute(), getSecond(),
                getDay(), getMonth(), getYear());
    }

    public void tick() {
        second++;
        if (getSecond() == 60) {
            minute++;
            second = 0;
        }
        if (getMinute() == 60) {
            hour++;
            minute = 0;
        }
        if (getHour() == 24) {
            day++;
            hour = 0;
        }
        if (day > daysPerMonth[month]) {
            month++;
            day = 1;
        }
        if (month > 12) {
            year++;
            month = 1;
        }
    }
}

public class Ch8Ex12 {
    public static void main(String[] args) {
        dateAndTime dt = new dateAndTime(23, 58, 58, 31, 12, 1999);
        while (true) {
            try {
                System.out.printf("%n%s", dt.toString());
                dt.tick();
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
        }
    }
}
