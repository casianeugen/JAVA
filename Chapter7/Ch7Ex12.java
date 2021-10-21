import java.util.Scanner;

public class Ch7Ex12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[5];
        System.out.println("Insert 5 numbers between 10 and 100: ");
        for(int i = 0; i < array.length; i++){
            System.out.printf("Array[%d]: ", i);
            array[i] = input.nextInt();
            while(array[i] < 10 || array[i] > 100){
                System.out.println("Reminder, between 10 and 100");
                System.out.printf("Array[%d]: ", i);
                array[i] = input.nextInt();
            }
        }
        System.out.println("Array of duplicates: ");
        for (int i = 0; i < array.length; i++) {
            boolean cond = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]){
                    cond = true;
                    break;
                }
            }
            if (!cond)
                System.out.printf("%d ", array[i]);
        }
    }
}
