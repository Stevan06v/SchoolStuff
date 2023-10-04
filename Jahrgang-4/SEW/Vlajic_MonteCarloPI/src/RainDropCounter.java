public class RainDropCounter {

    private static final RainDropCounter instance = new RainDropCounter();

    private int hits;

    private RainDropCounter(){}

    public static RainDropCounter getInstance() {
        return instance;
    }

    public void count(){
        synchronized (this){
            this.hits++;

        }
    }

    public void clear(){
        this.hits = 0 ;
    }

    public int getHits() {
        return hits;
    }
}
