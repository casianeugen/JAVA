public class Ch5Ex13 {
    public static void main(String[] args) {
        long factorial = 1;
        System.out.print("Number\t\tFactorial\n");
        for(int i = 1; i <= 20; i++){
            factorial *= i;
            System.out.printf("%d\t\t\t%d%n", i, factorial);
        }
    }
}
