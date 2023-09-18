import java.util.*;

public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        System.out.print("==========================================\n");

        System.out.print("Please enter the number of rain drops to simulate: ");
        int rainDropCount = sc.nextInt();

        System.out.print("Please enter number of threads to use: ");
        int threadCount = sc.nextInt();


        System.out.print("==========================================\n");

        System.out.printf("Performing sequential calculation with %d rain drops.: ", rainDropCount);

        long startTime2 = System.nanoTime();

        RainDropSimulator simulator = new RainDropSimulator(rainDropCount);

        simulator.run();

        long endTime2 = System.nanoTime();
        long elapsedTime2 = endTime2 - startTime2;


        double result2 = 4 * (RainDropCounter.getInstance().getHits() / (double)(rainDropCount));

        System.out.printf("Result: %f \n", result2);
        System.out.printf("Elapsed Time: %d ns \n", elapsedTime2);

        System.out.print("==========================================\n");

        // clear count
        RainDropCounter.getInstance().clear();


        List<Thread> threads = new LinkedList<>();

        int dropPerThread = rainDropCount / threadCount;

        System.out.printf("Performing multi-threaded calculation with %f rain drops. \n",rainDropCount/(double)threadCount);

        long startTime = System.nanoTime();


        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(new RainDropSimulator(dropPerThread)));
        }

        // start the threads
        for (Thread iterator : threads){
            iterator.start();
        }

        // join the threads
        for (Thread iterator : threads){
            try {
                iterator.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        double result = 4 * (RainDropCounter.getInstance().getHits() / (double)(rainDropCount));

        System.out.printf("Result: %f \n", result);
        System.out.printf("Elapsed Time: %d ns \n", elapsedTime);


        System.out.printf("Multithreading is times faster: ", elapsedTime2 / elapsedTime);

    }
}