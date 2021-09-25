import java.util.Scanner;

public class Ch4Ex23 {
    public static void main(String[] args) {
        int counter = 0;
        int number;
        int largest = 0;
        int secondLargest = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 numbers: ");
        while (counter < 10) {
            number = input.nextInt();
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            }
            if (number < largest) {
                if (number > secondLargest) {
                    secondLargest = number;
                }
            }
            counter++;
        }
        System.out.printf("The largest number is %d%n", largest);
        System.out.printf("The second largest number is %d%n", secondLargest);
    }
}
