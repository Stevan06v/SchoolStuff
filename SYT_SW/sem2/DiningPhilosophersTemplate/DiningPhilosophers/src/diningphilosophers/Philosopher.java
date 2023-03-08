package diningphilosophers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author syt@htl-leonding.ac.at
 **/

public class Philosopher extends Thread {
    
    private Forks forks;
    private int id;
    private int forkLeft;
    private int forkRight;
    private int nrDishes;

    /*
    ===========================================
    Lösung durch unterschiedliche Gabelaufnahme
    ===========================================
    public Philosopher(Forks f, int id, int nrDishes){
        forks = f;
        this.id = id;
        if(id == 0){
            this.forkLeft = (id + 1) % Main.NR_PHILOSOPHERS;
            this.forkRight = id;
        }else{
            this.forkLeft = id;
            this.forkRight = (id + 1) % Main.NR_PHILOSOPHERS;
        }
        this.nrDishes = nrDishes;
    }
    */

    public Philosopher(Forks f, int id, int nrDishes){
        forks = f;
        this.id = id;
        this.forkLeft = id;
        this.forkRight = (id + 1) % Main.NR_PHILOSOPHERS;
        this.nrDishes = nrDishes;
    }

    @Override
    public void run() {
        for (int i = 0; i < nrDishes; i++){
            think(1);
            // Try to start eating
            print(" wants Fork-" + forkLeft);
            forks.take(forkLeft);
            print(" took Fork-" + forkLeft);
            think(1);
            print(" wants Fork-" + forkRight);
            forks.take(forkRight);
            print(" took Fork-" + forkLeft);
           
            // Eating and thinking
            print(" EATING Dish-"+ i);
            think(2);
            
            // finished with eating
            forks.place(forkLeft);
            print(" released Fork-" + forkLeft);
            think(1);
            forks.place(forkRight);
            print(" released Fork-" + forkRight);
        }
    }

    private void think(int time) {
        try{
            this.sleep((long)(time * 1000.0));
            //this.sleep((long)(time * 10000.0 * Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void print(String text) {      
        String blanks = "";
        for (int i = 0; i < id * 20; i++){
            blanks += " ";
        }
        System.out.println(blanks + "Phil-" + id  + text);
    }  
}
