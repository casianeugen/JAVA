import java.util.Scanner;

public class Ex33 {
    public static void main(String[] args) {
        float weight;
        float height;
        Scanner input = new Scanner(System.in);

        System.out.print("Insert your weight in kilograms: ");
        weight = input.nextFloat();
        System.out.print("Insert your height in meters: ");
        height = input.nextFloat();
        System.out.println("BMI VALUES\n" +
                "Underweight: less than 18.5\n" +
                "Normal: between 18.5 and 24.9\n" +
                "Overweight: between 25 and 29.9\n" +
                "Obese: 30 or greater\n");
        System.out.printf("Yor BMI is %f", weight/(height*height));
    }
}