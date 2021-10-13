import java.util.Scanner;

class rightTriangle{
    public boolean checkAngles(int side1, int side2, int side3){
        if(Math.pow(side1, 2) == Math.pow(side2, 2) + Math.pow(side3, 2))
            return true;
        else if(Math.pow(side2, 2) == Math.pow(side1, 2) + Math.pow(side3, 2))
            return true;
        else return Math.pow(side3, 2) == Math.pow(side1, 2) + Math.pow(side2, 2);
    }
}
public class Ch4Ex36 {
    public static void main(String[] args) {
        rightTriangle sides = new rightTriangle();
        Scanner input = new Scanner(System.in);
        System.out.println("Input sides values:");
        System.out.print("Side1: ");
        int side1 = input.nextInt();
        System.out.print("Side2: ");
        int side2 = input.nextInt();
        System.out.print("Side3: ");
        int side3 = input.nextInt();

        if(sides.checkAngles(side1, side2, side3))
            System.out.println("Is a right triangle");
        else
            System.out.println("Is not a right triangle");
    }
}
