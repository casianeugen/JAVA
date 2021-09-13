class Invoice{
    private String number;
    private String description;
    private int quantity;
    private double price;

    public Invoice(String number, String description, int quantity, double price) {
        this.number = number;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getInvoiceAmount(int quantity, double price){
        if(quantity < 0)
            quantity = 0;
        if(price < 0)
            price = 0.0;
        return quantity * price;
    }
}
public class Ex12 {
    public static void main(String[] args) {
        Invoice inv1 = new Invoice("23214", "Milk", 1, 2.5);
        Invoice inv2 = new Invoice("23215", "Bread", 4, 1.2);
        Invoice inv3 = new Invoice("23216", "Water", 0, 2.8);
        Invoice inv4 = new Invoice("23217", "Donut", 2, -2.5);

        //Print invoices information
        System.out.printf("%nNo %s contain %s, quantity %d on price %.2f",
                inv1.getNumber(), inv1.getDescription(), inv1.getQuantity(), inv1.getPrice());
        System.out.printf("%nNo %s contain %s, quantity %d on price %.2f",
                inv2.getNumber(), inv2.getDescription(), inv2.getQuantity(), inv2.getPrice());
        System.out.printf("%nNo %s contain %s, quantity %d on price %.2f",
                inv3.getNumber(), inv3.getDescription(), inv3.getQuantity(), inv3.getPrice());
        System.out.printf("%nNo %s contain %s, quantity %d on price %.2f",
                inv4.getNumber(), inv4.getDescription(), inv4.getQuantity(), inv4.getPrice());

        // Get invoice amount
        System.out.printf("%nTotal price of invoice %s: $%.2f",
                inv1.getNumber(), inv1.getInvoiceAmount(inv1.getQuantity(), inv1.getPrice()));
        System.out.printf("%nTotal price of invoice %s: $%.2f",
                inv2.getNumber(), inv2.getInvoiceAmount(inv2.getQuantity(), inv2.getPrice()));
        System.out.printf("%nTotal price of invoice %s: $%.2f",
                inv3.getNumber(), inv3.getInvoiceAmount(inv3.getQuantity(), inv3.getPrice()));
        System.out.printf("%nTotal price of invoice %s: $%.2f",
                inv4.getNumber(), inv4.getInvoiceAmount(inv4.getQuantity(), inv4.getPrice()));


    }
}
