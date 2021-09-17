import java.util.Scanner;

public class Ch2Ex30 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = 0;
        StringBuilder s = new StringBuilder();
        boolean t = true;

        System.out.println("Insert a number with 5 digits:");
        while(t){
            number = input.nextInt();
            if (number < 10000 || number > 99999)
                System.out.println("Number is not a 5 digits, try again!");
            else
                t = false;
        }

        while (number > 0){
            s.append(number % 10).append("   ");
            number /= 10;
        }
        System.out.println(s);
    }
}
