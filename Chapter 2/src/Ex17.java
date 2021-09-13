import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {
        int num1;
        int num2;
        int num3;
        Scanner input = new Scanner(System.in);

        System.out.print("Insert first number: ");
        num1 = input.nextInt();
        System.out.print("Insert second number: ");
        num2 = input.nextInt();
        System.out.print("Insert third number: ");
        num3 = input.nextInt();

        System.out.printf("Sum: %d%n", num1 + num2 + num3);
        System.out.printf("Prod: %d%n", num1 * num2 * num3);
        System.out.printf("Avg: %d%n", (num1 + num2 + num3) / 3);
        if(num1 >= num2 && num1 >= num3)
            System.out.printf("%d is largest%n", num1);
        else if(num2 >= num1 && num2 >= num3)
            System.out.printf("%d is largest%n", num2);
        else
            System.out.printf("%d is largest%n", num3);
        if(num1 <= num2 && num1 <= num3)
            System.out.printf("%d is smallest%n", num1);
        else if(num2 <= num1 && num2 <= num3)
            System.out.printf("%d is smallest%n", num2);
        else
            System.out.printf("%d is smallest%n", num3);
    }
}
