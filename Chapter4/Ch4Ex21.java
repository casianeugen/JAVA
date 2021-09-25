import java.util.Scanner;

public class Ch4Ex21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = 0;
        int number;
        int largest = 0;
        System.out.println("Insert 10 numbers: ");
        while(counter < 10){
            number = input.nextInt();
            if(number > largest)
                largest = number;
            counter++;
        }
        System.out.printf("The largest number is: %d", largest);
    }
}
