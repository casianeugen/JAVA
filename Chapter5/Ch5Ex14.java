public class Ch5Ex14 {
    public static void main(String[] args) {
        double amount;
        double principal = 1000.0;
        for(double rate = 0.05; rate <= 0.1; rate = rate + 0.01){
            int year;
            System.out.println("----------------------------------------");
            System.out.printf("Rate %.2f%n Year\t\t  Amount on deposit\n", rate);
            for (year = 1; year <= 10; ++year){
                amount = principal * Math.pow(1.0 + rate, year);
                System.out.printf("%2d%,20.2f%n", year, amount);
            }
        }

    }
}
