import java.util.Scanner;

class decimalToBinary{
    public int convertToBinary(long binNumber){
        int decNumber = 0;
        int inc = 1;
        while (binNumber > 0){
            decNumber += binNumber % 10 * inc;
            binNumber /= 10;
            inc *= 2;
        }
        return decNumber;
    }
    public boolean checkBinary(long binNumber){
        if (binNumber == 0 || binNumber == 1 || binNumber < 0){
            System.out.print("Is not a binary number, try again!\n");
            return false;
        }
        while (binNumber != 0){
            if(binNumber % 10 > 1){
                System.out.print("Is not a binary number, try again!\n");
                return false;
            }
            binNumber /= 10;
        }
        return true;
    }
}
public class Ch4Ex31 {
    public static void main(String[] args) {
        decimalToBinary db = new decimalToBinary();
        Scanner input = new Scanner(System.in);
        long binary;
        System.out.print("Insert your binary number (only 1s and 0s): ");
        binary = input.nextInt();
        while (!db.checkBinary(binary)){
            binary = input.nextInt();
        }
        System.out.printf("Decimal equivalent of a %d is %d", binary, db.convertToBinary(binary));

    }
}
