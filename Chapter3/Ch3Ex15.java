import java.util.Scanner;

class Account15 {
    private String name;
    private double balance;

    public Account15() {
    }

    public Account15(String name, double balance) {
        this.name = name;
        if(balance > 0.0)
            this.balance = balance;
    }
    public void deposit(double depositAmount){
        if(depositAmount > 0.0)
            balance += depositAmount;
    }
    public void withdraw(double withdrawAmount){
        if(withdrawAmount > 0.0)
            balance -= withdrawAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
public class Ch3Ex15 {
    public static void displayAccount(Account15 accountToDisplay){
        System.out.printf("Account name: %s%nBalance: %f%n%n",
                accountToDisplay.getName(), accountToDisplay.getBalance());
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account15 acc3 = new Account15("Name Surname 3", 50.00);
        Account15 acc4 = new Account15("Name Surname 4", -7.53);
        Account15 acc5 = new Account15();

        acc5.setName("Name Surname 5");
        acc5.setBalance(50.50);

        displayAccount(acc3);
        displayAccount(acc4);
        displayAccount(acc5);

        //deposit
        System.out.println("Enter deposit amount for account1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%n adding %.2f to account balance%n%n",
                depositAmount);
        acc3.deposit(depositAmount);

        //withdraw acc3
        System.out.println("Enter amount for withdraw for acc3:");
        double withdrawAmount = input.nextDouble();
        if(withdrawAmount <= acc3.getBalance()){
            acc3.withdraw(withdrawAmount);
            System.out.println("\n Successful withdraw");
        }
        else
            System.out.println("Withdraw amount exceeded account balance");

        //withdraw acc4
        System.out.println("Enter amount for withdraw for acc4:");
        withdrawAmount = input.nextDouble();
        if(withdrawAmount <= acc4.getBalance()){
            acc4.withdraw(withdrawAmount);
            System.out.println("\nSuccessful withdraw");
        }
        else
            System.out.println("Withdraw amount exceeded account balance");

        //withdraw acc5
        System.out.println("Enter amount for withdraw for acc5:");
        withdrawAmount = input.nextDouble();
        if(withdrawAmount <= acc5.getBalance()){
            acc5.withdraw(withdrawAmount);
            System.out.println("\nSuccessful withdraw");
        }
        else
            System.out.println("Withdraw amount exceeded account balance");

        displayAccount(acc3);
        displayAccount(acc4);
        displayAccount(acc5);
    }
}