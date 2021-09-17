import java.util.Scanner;

public class Ch2Ex15 {
    public static void main(String[] args) {
        int num1;
        int num2;
        Scanner input = new Scanner(System.in);

        System.out.print("Insert first number: ");
        num1 = input.nextInt();
        System.out.print("Insert second number: ");
        num2 = input.nextInt();

        System.out.printf("Sum: %d%n", num1 + num2);
        System.out.printf("Diff: %d%n", num1 - num2);
        System.out.printf("Prod: %d%n", num1 * num2);
        if(num1 == 0)
            System.out.printf("Divided by 0%n");
        else
            System.out.printf("Quot: %d%n", num1 / num2);
    }
}
