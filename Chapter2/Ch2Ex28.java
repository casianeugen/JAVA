import java.util.Scanner;

public class Ch2Ex28 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r;
        System.out.print("Insert radius of a circle: ");
        r = input.nextInt();

        System.out.printf("Diameter: %d%n", 2 * r);
        System.out.printf("Circumference: %.2f%n", 2 * Math.PI * r);
        System.out.printf("Area: %.2f%n", Math.PI * r * r);
    }
}
