import java.util.Scanner;

public class Ch4Ex22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxValue;
        int N = 0;
        System.out.println("Insert max value for looping: ");
        maxValue = input.nextInt();
        System.out.println("10*N\t\t100*N\t\t1000*N");
        while(N <= maxValue){
            System.out.printf("%-12d%-12d%d%n", N*10, N*100, N*1000);
            N++;
        }
    }
}
