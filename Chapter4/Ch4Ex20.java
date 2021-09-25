import java.util.Scanner;

class salaryCalc{
    double hours;
    double hourlyRate;

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double salary(double hours, double hourlyRate){
        if(hours > 40)
            return hourlyRate * 40 + hourlyRate * 1.5 * (hours - 40);
        return hourlyRate * hours;
    }
}
public class Ch4Ex20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        salaryCalc sc = new salaryCalc();
        int employee = 1;
        while (employee <= 3){
            System.out.printf("%nInsert worked hours for employee %d: ", employee);
            sc.setHours(input.nextDouble());
            System.out.printf("Insert hourly rate for employee %d: ", employee);
            sc.setHourlyRate(input.nextDouble());
            System.out.printf("Total salary for employee %d: ", employee);
            System.out.printf("%.2f%n", sc.salary(sc.getHours(), sc.getHourlyRate()));
            employee++;
        }
    }
}
