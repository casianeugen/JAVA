public class Ch7Ex15 {
    public static void main(String[] args) {
        int[] array = new int[10];
        if (args.length != 0)
            array = new int[Integer.parseInt(args[0])];
        System.out.printf("%s%8s%n", "Index", "Value");
        for (int counter = 0; counter < array.length; counter++)
            System.out.printf("%5d%8d%n", counter, array[counter]);
    }
}
