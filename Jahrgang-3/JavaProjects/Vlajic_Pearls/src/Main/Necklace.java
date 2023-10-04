package Main;

import java.util.List;

public class Necklace {

    Pearl start;
    //elem -> elem -> elem -> null


    public Necklace() {
        this.start = null;
    }

    public void addPearl(Pearl p)
    {

        if(start== null){
            p.setNext(this.start);
           this.start =p;
        }


    }




    public int getCount() {
        if(start == null){
            return 0;
        }
        int counter = 1;
        Pearl iterator = start;
        while(iterator.hasNext()){
            counter++;
        }
        return counter;
    }

    public Pearl removePearl() {
    if(start == null){
         return null;
    }
    Pearl temp = start;
    this.start=start.getNext();
        return temp;
    }


    public Pearl getPearlAtPosition(int idx) {
        Pearl iterator = start;
        for (int i = 0; i < idx; i++)
        {
            if(iterator.hasNext()) {
                iterator = iterator.next;
            }
            else{
                break;
            }
        }
        return  null;
    }


    public double getTotalWeight() {
        double maxWeight=0.0;
        if(start == null){
            return 0;
        }
        Pearl iterator = start;

        while(iterator.hasNext()){
            maxWeight += iterator.getWeight();
            iterator= iterator.getNext();
        }
        maxWeight += iterator.getWeight();
        return maxWeight;
    }
    @Override
    public String toString() {
        if(this.start == null){
            return "";
        }
        String x = this.start.toString();
        Pearl temp = this.start;
        while (temp.getNext() != null){
            temp = temp.getNext();
            x += "-" + temp.toString();
        }
        return  x;
    }

    public void removeAllPearls() {
       this.start =null;
    }

    public int getCountOfColoredPearls(String clr) {
        Pearl iterator = start;
        int counter = 0;
        while (iterator.hasNext()){
            if(iterator.getColor() == clr){
                counter++;
            }
            iterator=iterator.next;
        }
        return counter;
    }
}
