/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountingThreads;


/**
 *
 * @author Birgit
 */
public class CounterThread extends Thread {
    
    private ICounter counter;
    private int maxCount;
       
    CounterThread(ICounter c, int maxCount){
        counter = c;
        this.maxCount = maxCount;
    }
    
    public void run() {
            //System.out.println("Thread " + getName() + " gestartet");
            for (int i = 0; i < maxCount; i++) {
                counter.increment();
        }
    }
}
