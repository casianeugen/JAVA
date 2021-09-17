import java.util.Scanner;

public class Ch2Ex25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert a number: ");
        int number = input.nextInt();

        if (number % 2 == 0)
            System.out.printf("%nNumber %d is even", number);
        else
            System.out.printf("%nNumber %d is odd", number);
    }
}
