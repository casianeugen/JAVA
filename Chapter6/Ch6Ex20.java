import java.util.Scanner;

public class Ch6Ex20 {
    static double circleArea(double radius){
        return Math.PI * Math.pow(radius, 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius of circle: ");
        double radius = input.nextDouble();
        System.out.printf("Circle area is equal with %.2f", circleArea(radius));
    }
}
