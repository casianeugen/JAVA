import java.util.Scanner;

public class Ch6Ex18 {
    static void squareOfAsterisks(int side){
        for (int i = 0; i < side; i++){
            for(int j = 0; j < side; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of square: ");
        int side = input.nextInt();
        squareOfAsterisks(side);
    }
}
