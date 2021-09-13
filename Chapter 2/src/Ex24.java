import java.util.Scanner;

public class Ex24 {
    public static int smallest(int[] x){
        int max = x[0];
        if (max > x[1])
            max = x[1];
        if (max > x[2])
            max = x[2];
        if (max > x[3])
            max = x[3];
        if (max > x[4])
            max = x[4];
        return max;
    }

    public static int largest(int[] x){
        int max = x[0];
        if (max < x[1])
            max = x[1];
        if (max < x[2])
            max = x[2];
        if (max < x[3])
            max = x[3];
        if (max < x[4])
            max = x[4];
        return max;
    }

    public static void main(String[] args) {
        int[] x = new int[5];
        Scanner input = new Scanner(System.in);
        System.out.printf("Input numbers: %n");
        for(int i = 0; i < x.length; i++)
            x[i] = input.nextInt();
        int small = smallest(x);
        int large = largest(x);
        System.out.printf("Smallest number: %d%n", small);
        System.out.printf("Largest number: %d%n", large);
    }
}
