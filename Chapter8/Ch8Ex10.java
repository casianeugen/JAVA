enum TrafficLight {
    GREEN(60),
    YELLOW(1),
    RED(90);

    private final int time;

    TrafficLight(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}

public class Ch8Ex10 {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String[] colors = {"o", "o", "o", "o"};

    public static void main(String[] args) throws InterruptedException {
        TrafficLight tl = null;
        System.out.println(ANSI_GREEN + colors[0]);
        Thread.sleep(tl.GREEN.getTime() * 1000L);
        System.out.println(ANSI_YELLOW + colors[1]);
        Thread.sleep(tl.YELLOW.getTime() * 1000L);
        System.out.println(ANSI_RED + colors[2]);
        Thread.sleep(tl.RED.getTime() * 1000L);
    }
}
