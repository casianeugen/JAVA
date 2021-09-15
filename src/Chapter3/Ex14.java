package Chapter3;

import java.text.ParseException;
import java.text.SimpleDateFormat;

class Date14 {
    private int month;
    private int day;
    private int year;

    public Date14(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDate(int month, int day, int year){
        String dateString = month + "/" + day + "/" + year;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        try{
            java.util.Date dt1 = sdf.parse(dateString);
            System.out.println(dateString);
        } catch (ParseException e) {
            System.out.println(dateString + " Is Invalid Date");
        }
    }
}

public class Ex14 {
    public static void main(String[] args) {
        Date14 d1 = new Date14(4,30,1999);
        Date14 d2 = new Date14(15,30, 2012);

        d1.displayDate(d1.getMonth(), d1.getDay(), d1.getYear());
        d2.displayDate(d2.getMonth(), d2.getDay(), d2.getYear());
    }
}
