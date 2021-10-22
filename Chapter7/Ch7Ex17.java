import java.util.Random;

public class Ch7Ex17 {
    static Random random = new Random();
    static int rollDie1(){
        return random.nextInt(6) + 1;
    }
    static int rollDie2(){
        return random.nextInt(6) + 1;
    }
    static int sumDices(){
        return rollDie1() + rollDie2();
    }
    public static void main(String[] args) {
        int[] dices = new int[11];
        for (int i = 1; i <= 36000000; i++){
             dices[sumDices() - 2]++;
        }
        System.out.println("+-----------------+");
        System.out.println("|Sum |\tFrequency |");
        System.out.println("+-----------------+");
        for(int i = 0; i < dices.length; i++){
            System.out.printf("|%4d|%10d  |\n", i + 2, dices[i]);
            System.out.println("+-----------------+");
        }
    }
}
