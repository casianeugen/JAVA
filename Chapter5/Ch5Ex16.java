import java.util.Scanner;

public class Ch5Ex16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert 5 numbers between 1 and 30: ");
        int digit;
        int[] nums = new int[5];
        for(int i = 0; i < 5; i++){
            digit = input.nextInt();
            while(digit < 1 || digit > 30){
                System.out.println("Reminder, between 1 and 30");
                digit = input.nextInt();
            }
            nums[i] = digit;
        }
        for (int num : nums) {
            for (int j = 0; j < num; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
