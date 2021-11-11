class DateTick{
    private int month;
    private int day;
    private int year;

    private static final int [] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public DateTick(int day, int month, int year){
        if(month <= 0 || month > 12)
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");
        if(day <= 0 || (day > daysPerMonth[month] && ! (month == 2 && day == 29)))
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        if(month == 2 || day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    }

    public void tick() {
        day++;
        if (day > daysPerMonth[month]){
            month++;
            day = 1;
        }
        if (month > 12){
            year++;
            month = 1;
        }
    }
}
public class Ch8Ex8 {
    public static void main(String[] args) {
        DateTick dt1 = new DateTick(31, 12, 1999);
        while (true){
            try {
                System.out.printf("%n%s",dt1.toString());
                dt1.tick();
                Thread.sleep(1000);
            }
            catch (Exception ignored){}
        }
    }
}
