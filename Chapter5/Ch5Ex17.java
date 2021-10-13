import java.util.Scanner;

public class Ch5Ex17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double price = 0;
        char done;
        do {
            System.out.print("Enter a product number: ");
            int prod = input.nextInt();
            System.out.print("Enter a quantity: ");
            int quantity = input.nextInt();

            switch (prod) {
                case 1:
                    price += quantity * 2.98;
                    break;
                case 2:
                    price += quantity * 4.50;
                    break;
                case 3:
                    price += quantity * 9.98;
                    break;
                case 4:
                    price += quantity * 4.49;
                    break;
                case 5:
                    price += quantity * 6.87;
                    break;
            }
            System.out.print("Do you want to add another prod? (Y/N): ");
            done = input.next().charAt(0);
        } while (done == 'Y' || done == 'y');
        System.out.printf("%nTotal price of retail is: %.2f", price);


    }
}
