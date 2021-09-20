import java.util.Scanner;

class Account{
    private String name;
    private double balance;

    public Account() {
    }

    public Account(String name, double balance) {
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
public class Ch3Ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account acc1 = new Account("Name, Surname", 50.00);
        Account acc2 = new Account("Name, surname", -7.53);
        Account acc3 = new Account();

        acc3.setName("Name, Surname");
        acc3.setBalance(20.4);

        System.out.printf("%s balance: $%.2f%n",
                acc1.getName(), acc1.getBalance());
        System.out.printf("%s balance: $%.2f%n",
                acc2.getName(), acc2.getBalance());
        System.out.printf("%s balance: $%.2f%n",
                acc3.getName(), acc3.getBalance());

        //deposit
        System.out.println("Enter deposit amount for account1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%n adding %.2f to account balance%n%n",
                depositAmount);
        acc1.deposit(depositAmount);

        //withdraw acc1
        System.out.println("Enter amount for withdraw for acc1:");
        double withdrawAmount = input.nextDouble();
        if(withdrawAmount <= acc1.getBalance()){
            acc1.withdraw(withdrawAmount);
            System.out.println("\n Successful withdraw");
        }
        else
            System.out.println("Withdraw amount exceeded account balance");

        //withdraw acc2
        System.out.println("Enter amount for withdraw for acc2:");
        withdrawAmount = input.nextDouble();
        if(withdrawAmount <= acc2.getBalance()){
            acc2.withdraw(withdrawAmount);
            System.out.println("\nSuccessful withdraw");
        }
        else
            System.out.println("Withdraw amount exceeded account balance");

        System.out.println("Enter amount for withdraw for acc3:");
        withdrawAmount = input.nextDouble();
        if(withdrawAmount <= acc3.getBalance()){
            acc3.withdraw(withdrawAmount);
            System.out.println("\nSuccessful withdraw");
        }
        else
            System.out.println("Withdraw amount exceeded account balance");

        //display balances
        System.out.printf("%s balance: $%.2f%n",
                acc1.getName(), acc1.getBalance());
        System.out.printf("%s balance: $%.2f%n",
                acc2.getName(), acc2.getBalance());
        System.out.printf("%s balance: $%.2f%n",
                acc3.getName(), acc3.getBalance());
    }
}