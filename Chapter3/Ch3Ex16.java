import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class HeartRates{
    private String name;
    private String surname;
    private int month;
    private int day;
    private int year;

    public HeartRates(){}

    public HeartRates(String name, String surname, int month, int day, int year) {
        this.name = name;
        this.surname = surname;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public int personAge(int day, int month, int year){
        LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.of(LocalDate.now().getYear(),
                LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
        return (int) ChronoUnit.YEARS.between(birthdate, now);
    }

    public int maxHeartRate(){
        return 220 - personAge(day, month, year);
    }

    public int minTargetHeartRate(){
        return (int) (maxHeartRate() * 0.5);
    }

    public int maxTargetHeartRate(){
        return (int) (maxHeartRate() * 0.85);
    }
}
public class Ch3Ex16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HeartRates person0 = new HeartRates("Name", "Surname", 10, 20, 1999);
        HeartRates person1 = new HeartRates();
        System.out.println("Insert your: \nName: ");
        person1.setName(input.nextLine());
        System.out.println("Surname: ");
        person1.setSurname(input.nextLine());
        System.out.println("Day of birth: ");
        person1.setDay(input.nextInt());
        System.out.println("Month of birth: ");
        person1.setMonth(input.nextInt());
        System.out.println("Year of birth: ");
        person1.setYear(input.nextInt());

        //person 1 info
        System.out.printf("%n%s %s%n", person1.getName(), person1.getSurname());
        System.out.printf("Years: %d%n", person1.personAge(person1.getDay(), person1.getMonth(), person1.getYear()));
        System.out.printf("Maxim Heart Rates: %d%n", person1.maxHeartRate());
        System.out.printf("Target Heart Rates: Between %d and %d%n",person1.minTargetHeartRate(),
                person1.maxTargetHeartRate());

        //person 0 info
        System.out.printf("%n%s %s%n", person0.getName(), person0.getSurname());
        System.out.printf("Years: %d%n", person0.personAge(person0.getDay(), person0.getMonth(), person0.getYear()));
        System.out.printf("Maxim Heart Rates: %d%n", person0.maxHeartRate());
        System.out.printf("Target Heart Rates: Between %d and %d%n",person0.minTargetHeartRate(),
                person1.maxTargetHeartRate());
    }
}
