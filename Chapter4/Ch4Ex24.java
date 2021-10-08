import java.util.Scanner;

public class Ch4Ex24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int result;
        int passes = 0;
        int failures = 0;
        int studentCounter = 1;
        int x = 0;

        while (studentCounter <= 10){
            System.out.print("Enter result (1 = pass, 2 = fail): ");
            result = input.nextInt();
            if (result == 1){
                passes++;
                studentCounter++;
            }
            else if (result == 2){
                failures++;
                studentCounter++;
            }
            else
                System.out.println("Insert another number (only 1 or 2)");
        }

        System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);

        if(passes > 8)
            System.out.println("Bonus to instructor!");
    }
}
