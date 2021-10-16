import java.util.Random;
import java.util.Scanner;

public class Ch6Ex30 {
    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
    public static int getResult(int number, int numberWin){
        int gameStat = 0;
        if(number > numberWin)
            System.out.println("Too high. Try again.");
        if(number < numberWin)
            System.out.println("Too low. Try again");
        if(number == numberWin){
            gameStat = 1;
            System.out.println("Congratulations! You guessed the number!");
        }
        return gameStat;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int numberForWin = random.nextInt( 1000);
        System.out.println(numberForWin);
        int number;
        System.out.println("+------------Main Menu---------------+");
        System.out.println("|                                    |");
        System.out.println("|                Hi!                 |");
        System.out.println("|   Do you want to play the game?    |");
        System.out.println("|   If yes, just enter a number      |");
        System.out.println("|   between 1 and 1000 or 0 to exit  |");
        System.out.println("|                                    |");
        System.out.println("+------------------------------------+");
        do {
            number = input.nextInt();
            if(isBetween(number, 1, 1000)){
                if(getResult(number, numberForWin) == 1){
                    System.out.println("Do you want to play one more time?(Y/N)");
                    char c = input.next().charAt(0);
                    if(c == 'Y' || c == 'y')
                        main(new String[]{});
                    else{
                        System.out.println("Bye Bye");
                        System.exit(0);
                    }
                }
            }
            else if (number > 1000 || number < 0)
                System.out.println("Reminder, between 1 and 1000");
            else{
                System.out.println("Bye Bye");
                System.exit(0);
            }
        }
        while (number != 0);
    }
}
