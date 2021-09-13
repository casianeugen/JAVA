import java.util.Scanner;

public class Ex26 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert first number: ");
        int number1 = input.nextInt();
        System.out.print("Insert second number: ");
        int number2 = input.nextInt();

        if(number1 != 0) {
            System.out.printf("%d / %d = %d and Reminder %d%n", number1, number2, number1 / number2, number1 % number2);
            if (number1 % number2 == 0)
                System.out.print("The first number is a multiple of the second");
            else
                System.out.print("The first number isn't a multiple of the second");
        }
        else
                System.out.print("Divided by 0");
    }
}
