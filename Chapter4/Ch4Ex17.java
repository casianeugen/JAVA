import java.util.Scanner;

class gasMileage{
    double totalMiles, totalGallons;

    public double totalTripMPG(int miles, int gallons){
        totalMiles += miles;
        totalGallons += gallons;

        return miles / (double) gallons;
    }

    public double getTotalMiles() {
        return totalMiles;
    }

    public double getTotalGallons() {
        return totalGallons;
    }

    public double getTotalMPG(){
        return totalMiles / totalGallons;
    }
}
public class Ch4Ex17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        gasMileage mileage = new gasMileage();
        int miles;
        int gallons;
        char c = 'y';
        while (c != 'n'){
            System.out.println("Insert miles for this trip: ");
            miles = input.nextInt();
            System.out.println("Insert gallons for this trip: ");
            gallons = input.nextInt();
            System.out.printf("Miles per gallons for this trip: %.2f%n",
                    mileage.totalTripMPG(miles, gallons));
            System.out.println("Do you want to add another trip? (n/y)");
            c = input.next().charAt(0);
        }
        System.out.printf("Total Miles from trips: %.2f%nTotal Gallons: %.2f%n",
                mileage.getTotalMiles(), mileage.getTotalGallons());
        System.out.printf("MPG for all trips: %.2f%n", mileage.getTotalMPG());
    }
}
