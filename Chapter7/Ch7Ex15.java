public class Ch7Ex15 {
    public static void main(String[] args) {
        int[] array = null;
        if (args == null || args.length == 0)
            array = new int[10];
        else
            array = new int[Integer.parseInt(args[0])];
        for (int counter = 0; counter < array.length; counter++)
            System.out.printf("%5d%8d%n", counter, array[counter]);
    }
}
