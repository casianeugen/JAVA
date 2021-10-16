import java.util.Random;
import java.util.Scanner;

public class Ch6Ex29 {
    static String headTail(String[] parts){
        Random random = new Random();
        int randomPart = random.nextInt(parts.length);
        return parts[randomPart];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] parts = new String[]{"Head", "Tail"};
        int option;
        int heads = 0;
        int tails = 0;
        System.out.println("+-Choose option-+");
        System.out.println("| 1. Toss Coin  |");
        System.out.println("| 2. Exit       |");
        System.out.println("+---------------+");
        do{
            option = input.nextInt();
            switch (option){
                case 1: {
                    System.out.printf("%s%n", headTail(parts));
                    if(headTail(parts).equals("Head"))
                        heads++;
                    else
                        tails++;
                }
                break;
                case 2: {
                    System.out.printf("Heads: %d%nTails: %d%n", heads, tails);
                }
            }
        }
        while(option != 2);
    }
}
