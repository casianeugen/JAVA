import java.util.Scanner;

class Factorial{
    public double part_a(int x){
        if(x == 0)
            return 1;
        else
            return (x * part_a(x - 1));
    }
    public double part_b(int x){
        if(x == 0)
            return 1;
        else
            return  part_b(x - 1) + 1 / part_a(x);
    }
    public double part_c(int x){
        int count = 5;
        if (x == 0)
            return 1;
        else
            return part_c(x - 1) + part_b(x) * Math.pow(count, x);
    }
}
public class Ch4Ex37 {
    public static void main(String[] args) {
        Factorial fc = new Factorial();
        Scanner input = new Scanner(System.in);
        System.out.println("Insert value for X: ");
        int x = input.nextInt();
        System.out.printf("Factorial = %f%n", fc.part_a(x));
        System.out.printf("e = %f%n", fc.part_b(x));
        System.out.printf("e^x = %f%n", fc.part_c(x));

    }
}
