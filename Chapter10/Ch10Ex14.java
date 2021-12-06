import java.util.Calendar;

abstract class EmployeeCH10 {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private DateCH10 birthDay;

    public EmployeeCH10(String first, String last, String ssn,
                        int month, int day, int year){

        setFirstName(first);
        setLastName(last);
        setSocialSecurityNumber(ssn);

        birthDay = new DateCH10(month, day, year);
    }

    public void setFirstName(String first){
        this.firstName = first;
    }
    public void setLastName(String last){
        this.lastName = last;
    }
    public void setSocialSecurityNumber(String ssn){
        this.socialSecurityNumber = ssn;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getSocialSecurityNumber(){
        return this.socialSecurityNumber;
    }
    public DateCH10 getBirthday(){
        return this.birthDay;
    }

    @Override
    public String toString(){
        return String.format("%s %s\nsocial security number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    public abstract double earnings();
}

class HourlyEmployee extends EmployeeCH10 {
    private double wage;
    private double hours;

    public HourlyEmployee(String first, String last, String ssn,
                          double hourlyWage, double hoursWorked, int month, int day, int year){
        super(first, last, ssn, month, day, year);
        setWage(hourlyWage);
        setHours(hoursWorked);
    }

    public void setWage(double hourlyWage){
        if(hourlyWage >= 0.0f)
            this.wage = hourlyWage;
        else
            throw new IllegalArgumentException(
                    "Hourly wage must be >= 0.0f");
    }
    public void setHours(double hoursWorked){
        if((hoursWorked >= 0.0f) && (hoursWorked <= 168.0f))
            this.hours = hoursWorked;
        else
            throw new IllegalArgumentException(
                    "Hours worked must be >= 0.0f and <= 16.0f");
    }

    public double getWage(){
        return this.wage;
    }
    public double getHours(){
        return this.hours;
    }

    @Override
    public double earnings(){
        if(getHours() <= 40)
            return getWage() * getHours();
        else
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5f;
    }

    @Override
    public String toString(){
        return String.format("hourly employee: %s\n%s: $%,.2f; %s: %,.2f",
                super.toString(), "hourly wage", getWage(),
                "hours worked", getHours());
    }
}

class SalariedEmployee extends EmployeeCH10 {
    private double weeklySalary;

    public SalariedEmployee(String first, String last, String ssn, double salary,
                            int month, int day, int year){
        super(first, last, ssn, month, day, year);
        setWeeklySalary(salary);
    }
    public void setWeeklySalary(double salary){
        if(salary >= 0.0f)
            this.weeklySalary = salary;
        else
            throw new IllegalArgumentException(
                    "Weekly salary must be >= 0.0f");
    }

    public double getWeeklySalary(){
        return this.weeklySalary;
    }

    @Override
    public double earnings(){
        return getWeeklySalary();
    }

    @Override
    public String toString(){
        return String.format("salaried employee: %s\n%s: $%,.2f",
                super.toString(), "weekly salary", getWeeklySalary());
    }
}

class DateCH10 {
    private static final int MONTHS_IN_YEAR = 12;
    private static final int FEB_LEAP_YEAR = 29;

    private final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final String[] strMonths =
            {"", "January", "February", "March", "April", "May", "June", "July", "August",
                    "September", "October", "November", "December"};

    private static final String[] strDays =
            {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    private int[] date = new int[3];

    public DateCH10(){
        date[0] = 1;
        date[1] = 1;
        date[2] = 1900;
    }

    public DateCH10(int month, int day, int year){
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public DateCH10(String month, int day, int year){
        setYear(year);
        setStringMonth(month);
        setDay(day);
    }

    public DateCH10(int dayOfYear, int year){
        setYear(year);
        setLongFormDay(dayOfYear);
    }

    public void setMonth(int month){
        date[0] = checkMonth(month);
    }
    public void setStringMonth(String month){
        date[0] = checkStringMonth(month);
    }
    public void setDay(int day){
        date[1] = checkDay(day);
    }

    public void setLongFormDay(int dayOfYear){
        if(dayOfYear <= 0 || dayOfYear > 365)
            throw new IllegalArgumentException("day of year must be 1-365");

        int month = 1;

        if(isLeapYear() && daysPerMonth[2] != FEB_LEAP_YEAR)
            daysPerMonth[2] = FEB_LEAP_YEAR;

        while(dayOfYear > daysPerMonth[month]){
            dayOfYear -= daysPerMonth[month];
            month++;
        }

        setMonth(month);
        setDay(dayOfYear);
    }
    public void setYear(int year){
        date[2] = checkYear(year);
    }

    public int getMonth(){
        return date[0];
    }
    public int getDay(){
        return date[1];
    }
    public int getYear(){
        return date[2];
    }

    private int getDayOfYear(){
        int tmp = 0;

        for(int i=1; i<date[0]; i++){
            tmp += daysPerMonth[i];
        }
        return tmp + date[1];
    }

    private int checkStringMonth(String month){
        if(month.length() > 1)
            month = month.substring(0, 1).toUpperCase() + month.substring(1);

        for(int i=1; i<strMonths.length; i++){
            if(strMonths[i].equals(month))
                return i;
        }

        throw new IllegalArgumentException("invalid month string");
    }

    private int checkMonth(int testMonth){
        if(testMonth > 0 && testMonth <= MONTHS_IN_YEAR)
            return testMonth;
        else
            throw new IllegalArgumentException("month must be 1-12");
    }

    private int checkDay(int testDay){
        if(isLeapYear() && daysPerMonth[2] != FEB_LEAP_YEAR)
            daysPerMonth[2] = FEB_LEAP_YEAR;

        if(testDay > 0 && testDay <= daysPerMonth[getMonth()])
            return testDay;

        throw new IllegalArgumentException("day out of range for specified month and year");
    }

    private boolean isLeapYear(){
        return (getYear() % 400 == 0 || (getYear() % 4 == 0 && getYear() % 100 != 0));
    }

    private int checkYear(int testYear){
        if(testYear >= 0 && testYear <= 9999)
            return testYear;
        else
            throw new IllegalArgumentException("year must be 0-9999");
    }

    public String toString(){
        return String.format("%02d/%02d/%04d", date[0], date[1], date[2]);
    }
    public String toLongDateString(){
        return String.format("%s %02d %04d", strMonths[date[0]], date[1], date[2]);
    }
    public String toDayOfYearString(){
        return String.format("%03d %04d", getDayOfYear(), date[2]);
    }
}

class CommissionEmployee extends EmployeeCH10 {
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String first, String last, String ssn,
                              double sales, double rate, int month, int day, int year){
        super(first, last, ssn, month, day, year);
        setGrossSales(sales);
        setCommissionRate(rate);
    }

    public void setCommissionRate(double rate){
        if(rate > 0.0f && rate < 1.0f)
            this.commissionRate = rate;
        else
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0f and < 1.0f");
    }
    public void setGrossSales(double sales){
        if(sales >= 0.0f)
            this.grossSales = sales;
        else
            throw new IllegalArgumentException
                    ("Gross sales muse be >= 0.0f");
    }

    public double getCommissionRate(){
        return this.commissionRate;
    }
    public double getGrossSales(){
        return this.grossSales;
    }

    @Override
    public double earnings(){
        return getCommissionRate() * getGrossSales();
    }

    @Override
    public String toString(){
        return String.format("%s: %s\n%s: $%,.2f; %s: %.2f",
                "commission employee", super.toString(),
                "gross sales", getGrossSales(),
                "commission rate", getCommissionRate());
    }
}

class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;

    public BasePlusCommissionEmployee(String first, String last, String ssn,
                                      double sales, double rate, double salary, int month, int day, int year){
        super(first, last, ssn, sales, rate, month, day, year);
        setBaseSalary(salary);
    }

    public void setBaseSalary(double salary){
        if(salary >= 0.0f)
            baseSalary = salary;
        else
            throw new IllegalArgumentException(
                    "Base salary must be >= 0.0f");
    }

    public double getBaseSalary(){
        return this.baseSalary;
    }

    @Override
    public double earnings(){
        return getBaseSalary() + super.earnings();
    }

    @Override
    public String toString(){
        return String.format("%s %s; %s: $%,.2f",
                "base-salaried", super.toString(),
                "base salary", getBaseSalary());
    }
}

public class Ch10Ex14 {
    public static void main(String[] args) {
        int currentMonth = 1 + Calendar.getInstance().get(Calendar.MONTH);

        EmployeeCH10[] employees = new EmployeeCH10[5];

        employees[0] = new SalariedEmployee(
                "John", "Smith", "111-11-1111", 800.0f, 11, 3, 1883);
        employees[1] = new HourlyEmployee(
                "Karen", "Price", "222-22-2222", 16.75f, 40.0f, 12, 12, 1975);
        employees[2] = new CommissionEmployee(
                "Sue", "Jones", "333-33-3333", 10000.0f, .06f, 12, 13, 1965);
        employees[3] = new BasePlusCommissionEmployee(
                "Bob", "Lewis", "444-44-4444", 5000.0f, .04f, 300.0f, 12, 12, 1956);

        for(EmployeeCH10 currentEmployee : employees){
            System.out.println(currentEmployee);
            if(currentEmployee instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) currentEmployee;
                employee.setBaseSalary(1.10f * employee.getBaseSalary());
                System.out.printf("new base salary with 10%% increase is: $%,.2f\n",
                        employee.getBaseSalary());
            }
            System.out.printf("earned $%,.2f\n\n",
                    (currentEmployee.getBirthday().getMonth() == currentMonth) ?
                            currentEmployee.earnings() + 100.0f : currentEmployee.earnings());
        }
        for(int j=0; j<employees.length; j++){
            System.out.printf("Employee %d is a %s\n",
                    j, employees[j].getClass().getName());
        }
    }
}
