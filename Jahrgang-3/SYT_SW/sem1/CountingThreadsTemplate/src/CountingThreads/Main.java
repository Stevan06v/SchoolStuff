/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountingThreads;

/**
 *
 * @author syt@htl-leonding.ac.at
 */
public class Main {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        testCounterThreads("Test ohne Synchronisation", new Counter());
        testCounterThreads("Test mit Synchronized ", new SynchronizedCounter());;
        testCounterThreads("Busy waiting counter: ", new BusyWaitingCounter());;

     }

    private static void testCounterThreads(String testTitle, ICounter counter) {
        int maxCount = 1_000_000;
        counter.set(0);
        Thread t1 = new CounterThread(counter, maxCount);
        Thread t2 = new CounterThread(counter, maxCount);        
        Thread t3 = new CounterThread(counter, maxCount);

        System.out.print(testTitle + " geht jetzt los ... ");
        try{
            t1.start(); t2.start(); t3.start();
            t1.join(); t2.join(); t3.join();
        } catch (InterruptedException e){
            System.out.println("Thread interrupted");
        }
        finally {
            System.out.println("fertig. Wert sollte 3.000.000 sein und ist " + counter.get());
            //System.out.println(testTitle + " ist zu Ende.");
        }    
    }



    
}
