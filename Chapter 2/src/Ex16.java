import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        int num1;
        int num2;
        Scanner input = new Scanner(System.in);

        System.out.print("Insert first number: ");
        num1 = input.nextInt();
        System.out.print("Insert second number: ");
        num2 = input.nextInt();

        if(num1 > num2)
            System.out.printf("%d is larger", num1);
        else if (num1 < num2)
            System.out.printf("%d is larger", num2);
        else
            System.out.print("These numbers are equal");
    }
}
