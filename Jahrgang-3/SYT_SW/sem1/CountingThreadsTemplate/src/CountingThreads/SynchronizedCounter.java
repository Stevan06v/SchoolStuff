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
public class SynchronizedCounter implements ICounter{
    
    private int count = 0;
    @Override
    public void set(int count){
        this.count = count;
    }   
    @Override
    public void increment(){
        synchronized (this) {
            count++;
        }
    }   
    @Override
    public int get(){
        return count;
    }   
}
