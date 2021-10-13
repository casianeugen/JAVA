import java.util.Scanner;

class Triangle{
    public boolean checkSides(int side1, int side2, int side3){
        return side1 + side2 > side3 && side2 + side3 > side1 && side3 + side1 > side2;
    }
}
public class Ch4Ex35 {
    public static void main(String[] args) {
        Triangle sides = new Triangle();
        Scanner input = new Scanner(System.in);
        System.out.println("Input sides values:");
        System.out.print("Side1: ");
        int side1 = input.nextInt();
        System.out.print("Side2: ");
        int side2 = input.nextInt();
        System.out.print("Side3: ");
        int side3 = input.nextInt();
        if(sides.checkSides(side1, side2, side3))
            System.out.println("Sides for triangle are Valid");
        else
            System.out.println("Sides for triangle are Invalid");
    }
}
