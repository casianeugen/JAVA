public class Ch7Ex14 {
    static int product(int... numbers) {
        int product = 1;
        for (int number : numbers) {
            product *= number;
        }
        return product;
    }
    public static void main(String[] args) {
        System.out.printf("The product of 2 numbers is: %d%n", product(1, 2));
        System.out.printf("The product of 3 numbers is: %d%n", product(4, 5, 2));
        System.out.printf("The product of 4 numbers is: %d%n", product(6, 4, 12, 5));
        System.out.printf("The product of 5 numbers is: %d%n", product(5, 2, 31, 2, 53));
    }
}