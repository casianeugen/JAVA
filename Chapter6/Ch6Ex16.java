import java.util.Scanner;

public class Ch6Ex16 {
    static boolean isMultiple(int number1, int number2){
        return number1 % number2 == 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input 2 integer numbers: ");
        System.out.print("Number 1: ");
        int number1 = input.nextInt();
        System.out.print("Number 2: ");
        int number2 = input.nextInt();
        if(isMultiple(number1, number2))
            System.out.printf("Number %d is a multiple of number %d%n", number1, number2);
        else
            System.out.printf("Number %d is not a multiple of number %d%n", number1, number2);
    }
}
