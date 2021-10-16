import java.util.Scanner;

public class Ch6Ex19 {
    static void squareOfCharacters(int side, char type){
        for (int i = 0; i < side; i++){
            for(int j = 0; j < side; j++)
                System.out.print(type);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the square: ");
        int size = input.nextInt();
        System.out.print("Enter the type of character: ");
        char type = input.next().charAt(0);
        squareOfCharacters(size, type);
    }
}
