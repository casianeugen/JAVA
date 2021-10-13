import java.util.Scanner;

public class Ch4Ex32 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert number of lines: ");
        int lines = input.nextInt();
        while (lines != 0){
            if(lines % 2 == 0)
                System.out.print(" ");
            for(int i = 0; i < 10; i++)
                System.out.print("* ");
            System.out.println();
            lines--;
        }
    }
}
