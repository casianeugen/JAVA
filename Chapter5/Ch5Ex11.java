import java.util.Scanner;

public class Ch5Ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums;
        System.out.print("Specify the number of values to input: ");
        int number = input.nextInt();
        nums = new int[number];
        System.out.println("Enter all numbers: ");
        for(int i = 0; i < nums.length; i++){
            System.out.printf("Number %d: ", i + 1);
            nums[i] = input.nextInt();
        }
        int temp = nums[0];
        for (int num : nums) {
            if (temp >= num)
                temp = num;
        }
        System.out.printf("The smallest number is: %d", temp);
    }
}
