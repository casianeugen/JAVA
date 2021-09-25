import java.util.Scanner;

class salesCommission{
    double total;
    double itemPrice;

    public void getTotal() {
        total += getItemPrice();
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double commission(){
        return 200 + total * 0.09;
    }
}
public class Ch4Ex19 {
    public static void main(String[] args) {
        salesCommission sc = new salesCommission();
        Scanner input = new Scanner(System.in);
        System.out.println("Insert number of items: ");
        int items = input.nextInt();
        int counter = 1;
        while(counter <= items){
            System.out.printf("\nInsert item №%d price: $", counter);
            sc.setItemPrice(input.nextDouble());
            sc.getTotal();
            counter++;
        }
        System.out.printf("%nTotal price: $%.2f", sc.total);
        System.out.printf("%nCommission: $%.2f", sc.commission());
    }
}
