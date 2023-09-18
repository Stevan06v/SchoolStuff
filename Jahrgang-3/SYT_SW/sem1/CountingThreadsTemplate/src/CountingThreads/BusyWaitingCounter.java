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
public class BusyWaitingCounter implements ICounter{
    private  boolean available;
    private int count = 0;
    @Override
    public void set(int count){
        this.count = count;
    }   
    @Override
    public void increment(){
        aquire (this);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        count++;
        release();

    }

    private void aquire(BusyWaitingCounter busyWaitingCounter) {
        while (!available){
            System.out.println("waiting");
        }
        available = false;
    }

    private void release() {
        available = true;
    }

    @Override
    public int get(){
        return count;
    }   
}
