public class Ch5Ex12 {
    public static void main(String[] args) {
        int prod = 1;
        for(int i = 0; i < 16; i++){
            if(i % 2 != 0)
                prod *= i;
        }
        System.out.printf("Product of the odd numbers from 1 to 15: %d", prod);
    }
}
