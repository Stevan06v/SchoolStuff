package diningphilosophers;


import java.util.concurrent.Semaphore;

/**
 *
 * @author syt@htl-leonding.ac.at
 */
public class Forks {
    
    private int nrForks;
    // every fork needs a semaphore for mutual exclusion
    private Semaphore[] forkSemaphore;
    
    public Forks(int n){ 
        nrForks = n;
        forkSemaphore = new Semaphore[nrForks];
        for (int i = 0; i < nrForks; i++){
            forkSemaphore[i] = new Semaphore(1);
        }
    }
    public void take(int i){
        forkSemaphore[i].acquireUninterruptibly();
    }
    public void place(int i){
        forkSemaphore[i].release();
    }
}
