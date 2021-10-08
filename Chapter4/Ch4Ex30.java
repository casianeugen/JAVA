import java.util.Scanner;

public class Ch4Ex30 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 5 digit number");
        int number = input.nextInt();
        int sum = 0;
        int r;
        while(number < 10000 || number > 99999){
            System.out.println("Remind, a 5 digit number");
            number = input.nextInt();
        }
        int temp = number;
        while (number > 0){
            r = number % 10;
            sum = (sum * 10) + r;
            number = number / 10;
        }
        if(temp == sum)
            System.out.printf("Number %d is a palindrome", temp);
        else
            System.out.printf("Number %d is not a palindrome", temp);
    }
}
