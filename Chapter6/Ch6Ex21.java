import java.util.Scanner;

public class Ch6Ex21 {
    static int quotient(int number, int divisor){
        return number / divisor;
    }
    static int remainder(int number, int divisor){
        return number % divisor;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();
        System.out.printf("The quotient part of %d and %d is %d%n", number1, number2, quotient(number1, number2));
        System.out.printf("The remainder part of %d and %d is %d%n", number1, number2, remainder(number1, number2));
    }
}
