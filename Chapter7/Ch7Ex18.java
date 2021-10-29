import java.security.SecureRandom;

public class Ch7Ex18 {
    private static final SecureRandom randomNumbers = new SecureRandom();
    private enum Status { CONTINUE, WON, LOST }
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    public static void main(String[] args) {
        long[][] games = new long[2][21];
        long sumWin = 0;
        long sumLose = 0;
        for(long i = 0; i < Long.MAX_VALUE; i++) {
            int myPoint = 0;
            int rollCount = 0;
            Status gameStatus;
            int sumOfDice = rollDice();
            switch (sumOfDice) {
                case SEVEN, YO_LEVEN -> gameStatus = Status.WON;
                case SNAKE_EYES, TREY, BOX_CARS -> gameStatus = Status.LOST;
                default -> {
                    gameStatus = Status.CONTINUE;
                    myPoint = sumOfDice;
                }
            }

            while (gameStatus == Status.CONTINUE) {
                sumOfDice = rollDice();
                if (sumOfDice == myPoint)
                    gameStatus = Status.WON;
                else if (sumOfDice == SEVEN)
                    gameStatus = Status.LOST;
                rollCount++;
            }
            if (gameStatus == Status.WON)
                if (rollCount < games[0].length)
                    games[0][rollCount]++;
                else
                    games[0][20]++;
            else
                if (rollCount < games[1].length)
                    games[1][rollCount]++;
                else
                    games[0][20]++;
            System.out.println(i);
        }
        for (int i = 0; i < games[0].length; i++) {
            sumWin += games[0][i];
            sumLose += games[1][i];
        }
        for (int i = 0; i < games[0].length + 1; i++)
            System.out.print("--------");
        System.out.println();
        for (int i = 0; i < games[0].length; i++)
            if(i == games[0].length - 1)
                System.out.print("|   20+|");
            else
                System.out.printf("|%6d|", i + 1);
        System.out.println("\nWins");
        for (int i = 0; i < games[0].length; i++)
            System.out.printf("|%6d|", games[0][i]);
        System.out.println("\nLoses");
        for (int i = 0; i < games[1].length; i++)
            System.out.printf("|%6d|", games[1][i]);
        double chance = (double) sumWin / sumLose;
        System.out.printf("\nChances to win: %.2f%%", chance * 100);
    }

    public static int rollDice(){
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);

        return die1 + die2;
    }
}