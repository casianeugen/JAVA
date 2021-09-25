import java.util.Scanner;

class creditLimit{
    int accountNumber;
    int beginningBalance;
    int totalCharges;
    int totalCredits;
    int allowedCredit;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBeginningBalance() {
        return beginningBalance;
    }

    public void setBeginningBalance(int beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    public int getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(int totalCharges) {
        this.totalCharges = totalCharges;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public int getAllowedCredit() {
        return allowedCredit;
    }

    public void setAllowedCredit(int allowedCredit) {
        this.allowedCredit = allowedCredit;
    }

    public int getNewBalance(){
        return getBeginningBalance() + getTotalCharges() - getTotalCredits();
    }
}
public class Ch4Ex18 {
    public static void main(String[] args) {
        creditLimit cl = new creditLimit();
        Scanner input = new Scanner(System.in);
        char c = 'y';
        while(c == 'y'){
            System.out.println("Insert account number: ");
            cl.setAccountNumber(input.nextInt());
            System.out.println("Insert balance at the beginning of the month");
            cl.setBeginningBalance(input.nextInt());
            System.out.println("Insert total of all items charged by the customer this month");
            cl.setTotalCharges(input.nextInt());
            System.out.println("Insert total of all credits applied to the customer’s account this month");
            cl.setTotalCredits(input.nextInt());
            System.out.println("Insert allowed credit limit");
            cl.setAllowedCredit(input.nextInt());

            System.out.printf("%nAccount %d has new balance: $%d%n", cl.getAccountNumber(), cl.getNewBalance());

            if(cl.getNewBalance() < cl.getAllowedCredit())
                System.out.printf("Credit limit exceeded. Allowed credit ($%d) " +
                                "need to be smaller than new balance ($%d)%n",
                        cl.getAllowedCredit(), cl.getNewBalance());
            else
                System.out.println("Credit accepted!");

            System.out.println("Do you want to add another acc? (y/n)");
            c = input.next().charAt(0);
        }
    }
}
