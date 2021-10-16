import java.util.Scanner;

public class Ch6Ex17 {
    static boolean isEven(int even){
        return even % 2 == 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        if(isEven(number))
            System.out.printf("Number %d is even%n", number);
        else
            System.out.printf("Number %d is odd%n", number);
    }
}
