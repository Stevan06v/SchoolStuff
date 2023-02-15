package CountingThreads;


import java.util.concurrent.Semaphore;

public class SemaphorCounter implements ICounter{
    private int count = 0;
    Semaphore mutex = new Semaphore(1);
    @Override
    public void set(int count) {
        this.count = count;
    }
    @Override
    public void increment(){
        mutex.acquireUninterruptibly();
        count++;
        mutex.release();
    }
    @Override
    public int get(){
        return count;
    }
}
