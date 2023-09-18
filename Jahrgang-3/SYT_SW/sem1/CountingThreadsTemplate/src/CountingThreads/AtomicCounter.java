package CountingThreads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements ICounter{

    private AtomicInteger count = new AtomicInteger(0);
    @Override
    public void set(int count){
        this.count.set(count);
    }

    // Kritische Sektion
    @Override
    public void increment(){
        this.count.incrementAndGet(); // wie ++ nur unteilbar
    }
    @Override
    public int get(){
        return this.count.get();
    }
}
