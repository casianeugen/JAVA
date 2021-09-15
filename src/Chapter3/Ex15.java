package Chapter3;

import java.util.Scanner;

class Account15 {
    private String name;
    private double balance;

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
}
public class Ex15 {
    public static void displayAccount(Account15 accountToDisplay){
        System.out.printf("Account name: %s%nBalance: %f%n%n",
                accountToDisplay.getName(), accountToDisplay.getBalance());
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account15 acc3 = new Account15("Name Surname", 50.00);
        Account15 acc4 = new Account15("Name surname", -7.53);

        displayAccount(acc3);
        displayAccount(acc4);
        //deposit
        System.out.println("Enter deposit amount for account1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%n adding %.2f to account balance%n%n",
                depositAmount);
        acc3.deposit(depositAmount);

        //withdraw acc1
        System.out.println("Enter amount for withdraw for acc1:");
        double withdrawAmount = input.nextDouble();
        if(withdrawAmount <= acc3.getBalance()){
            acc3.withdraw(withdrawAmount);
            System.out.println("\n Successful withdraw");
        }
        else
            System.out.println("Withdraw amount exceeded account balance");

        //withdraw acc2
        System.out.println("Enter amount for withdraw for acc2:");
        withdrawAmount = input.nextDouble();
        if(withdrawAmount <= acc4.getBalance()){
            acc4.withdraw(withdrawAmount);
            System.out.println("\nSuccessful withdraw");
        }
        else
            System.out.println("Withdraw amount exceeded account balance");

        displayAccount(acc3);
        displayAccount(acc4);
    }
}