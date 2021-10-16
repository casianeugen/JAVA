import java.io.IOException;
import java.util.Scanner;

public class Ch6Ex22{
    static double celsius(double temperature){
        return (double) 5 / 9 * (temperature - 32);
    }

    static double fahrenheit(double temperature){
        return (double) 9 / 5 * temperature + 32;
    }
    static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        double temperature;
        do {
            clearScreen();
            System.out.println("+---------------Choose converter--------------+");
            System.out.println("|  1. Celsius to Fahrenheit                   |");
            System.out.println("|  2. Fahrenheit to Celsius                   |");
            System.out.println("|                                             |");
            System.out.println("|                                 0 - exit    |");
            System.out.println("+---------------------------------------------+");
            int number = input.nextInt();
            switch (number){
                case 1 : {
                    System.out.print("Insert temperature in Celsius: ");
                    temperature = input.nextDouble();
                    System.out.printf("%.2f Celsius -> %.2f Fahrenheit%n", temperature, fahrenheit(temperature));
                }
                break;
                case 2 : {
                    System.out.print("Insert temperature in Fahrenheit: ");
                    temperature = input.nextDouble();
                    System.out.printf("%.2f Fahrenheit -> %.2f Celsius%n", temperature, celsius(temperature));
                }
                break;
                case 0 : {
                    System.out.println("Exit from converter");
                    System.exit(1);
                }
            }
        }
        while (true);
    }
}
