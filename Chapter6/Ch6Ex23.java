import java.util.Scanner;

public class Ch6Ex23 {
    static double minimum3(double n1, double n2, double n3){
        if(Math.min(n1, n2) == Math.min(n1, n3))
            return n1;
        if (Math.min(n1, n2) == Math.min(n2, n3))
            return n2;
        return n3;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 3 number: ");
        System.out.print("Number 1: ");
        double number1 = input.nextDouble();
        System.out.print("Number 2: ");
        double number2 = input.nextDouble();
        System.out.print("Number 3: ");
        double number3 = input.nextDouble();
        System.out.printf("The smallest value of %.2f, %.2f and %.2f is %.2f", number1, number2, number3,
                minimum3(number1, number2, number3));
    }
}
