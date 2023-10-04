import java.util.concurrent.ThreadLocalRandom;

public class RainDropSimulator implements Runnable {
    private final int dropCount;
    private int threadCount;

    public RainDropSimulator(int dropCount) {
        this.dropCount = dropCount;
    }

    @Override
    public void run() {
        System.out.println("Running...");
        for (int i = 0; i < this.dropCount; i++) {

            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();

            if (inCircle(x, y)) {
                RainDropCounter.getInstance().count();
            }
        }
    }

    private boolean inCircle(double x, double y) {
        double border = 1.0;

        double hypotenuse = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        return hypotenuse <= border;
    }



    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }
    public int getDropCount() {
        return dropCount;
    }
    public int getThreadCount() {
        return threadCount;
    }
}
