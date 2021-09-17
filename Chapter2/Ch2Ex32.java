import java.util.Scanner;

public class Ch2Ex32 {
    public static void main(String[] args) {
        int[] x = new int[5];
        int poz = 0;
        int neg = 0;
        int zero = 0;
        Scanner input = new Scanner(System.in);
        System.out.printf("Input numbers: %n");
        for(int i = 0; i < x.length; i++){
            x[i] = input.nextInt();
            if(x[i] < 0)
                neg++;
            if(x[i] > 0)
                poz++;
            if(x[i] == 0)
                zero++;
        }
        System.out.printf("Negative: %d%nPositive: %d%nZero: %d%n", neg, poz, zero);

    }
}
