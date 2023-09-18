package diningphilosophers;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author syt@htl-leonding.ac.at
 */
public class Main {

    public static final int NR_PHILOSOPHERS = 5;
    public static final int NR_DISHES = 3; // amount of dishes for each philosopher => '10-Gang-Menü"
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create as many forks as philosophers
        Forks forks = new Forks(NR_PHILOSOPHERS);

        // create the given amount of philosophers (each is an own thread)
        Philosopher[] philosophers = new Philosopher[NR_PHILOSOPHERS];

        // start all philosophers
        for (int i = 0; i < NR_PHILOSOPHERS; i++){
            philosophers[i] = new Philosopher(forks, i, NR_DISHES);
       }

       philosophers[0].start();
       philosophers[2].start();
       philosophers[4].start();
       philosophers[1].start();
       philosophers[3].start();

        // wait for all philosophers that have finished there lunch
        for (int i = 0; i < NR_PHILOSOPHERS; i++){
            try {
                philosophers[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Lunch is terminated.");
    }
}
