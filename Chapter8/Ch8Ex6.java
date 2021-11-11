class SavingAccount{
    private static double annualInterestRate = 0.0;
    private double savingBalance = 0.0;

    public SavingAccount(double savingBalance) {
        setSavingBalance(savingBalance);
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public static void modifyInterestRate(double interestRate){
        if (interestRate >= 0)
            annualInterestRate = interestRate;
        else
            throw new IllegalArgumentException("Interest rate must be > 0");
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void calculateMonthlyInterest(){
        savingBalance += (savingBalance * annualInterestRate) / 12;
    }

    public String toString(){
        return String.format("%.2f%n", getSavingBalance());
    }
}
public class Ch8Ex6{
    public static void main(String[] args) {
        SavingAccount saver1 = new SavingAccount(2000);
        SavingAccount saver2 = new SavingAccount(3000);

        SavingAccount.modifyInterestRate(0.04);
        saver1.calculateMonthlyInterest();
        SavingAccount.modifyInterestRate(0.04);
        saver2.calculateMonthlyInterest();

        System.out.printf("Saver 1 (4%%): %s", saver1);
        System.out.printf("Saver 2 (4%%): %s", saver2);

        SavingAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        SavingAccount.modifyInterestRate(0.05);
        saver2.calculateMonthlyInterest();

        System.out.printf("Saver 1 (5%%): %s", saver1);
        System.out.printf("Saver 2 (5%%): %s", saver2);
    }
}
