import java.util.Scanner;

public class Ch6Ex26 {
    static int reverseDigits(int number){
        int remainder;
        int reverse = 0;
        while(number > 0) {
            remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number /= 10;
        }
        return reverse;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        System.out.printf("Reverse -> %d%n", reverseDigits(number));
    }
}
