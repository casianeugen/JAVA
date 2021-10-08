import java.util.Scanner;

public class Ch4Ex29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        System.out.print("Enter the size of the square (between 1 and 20): ");
        size = input.nextInt();
        while (size < 1 || size > 20){
            System.out.println("Try again! Remind between 1 and 20");
            size = input.nextInt();
        }
        int a = 0;
        while (a++ < size)
            System.out.print("*");
        System.out.println();
        a = 0;
        while(a++ < size - 2){
            System.out.print("*");
            int b = 0;
            while (b++ < size - 2)
                System.out.print(" ");
            System.out.println("*");
        }
        a = 0;
        while (a++ < size)
            System.out.print("*");
    }
}
