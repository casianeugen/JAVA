import java.util.Scanner;

class Rectangle{
    double width;
    double length;

    public Rectangle() {
        width = 1;
        length = 1;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0.0 && width <= 20.0)
            this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length > 0.0 && length <= 20.0)
            this.length = length;
    }

    double perimeter (double length, double width){
        return 2 * (length + width);
    }

    double area (double length, double width){
        return length * width;
    }

}
public class Ch8Ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rectangle r1 = new Rectangle();
        System.out.print("Enter a length of rectangle: ");
        r1.setLength(input.nextInt());
        System.out.print("Enter a width of rectangle: ");
        r1.setWidth(input.nextInt());
        System.out.printf("Area: %.2f%n", r1.area(r1.getLength(), r1.getWidth()));
        System.out.printf("Perimeter: %.2f%n", r1.perimeter(r1.getLength(), r1.getWidth()));
    }
}
