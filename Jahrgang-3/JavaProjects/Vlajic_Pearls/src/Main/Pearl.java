package Main;

import java.util.Locale;

public class Pearl {

    private String color;
    private double weight;
    public Pearl item;
    public Pearl next;

    public Pearl(String color, double weight) {

        if(weight < 0){
            this.weight = 1.0;
        }else{
            this.weight = weight;
        }

        if(color == "Red" || color == "Green" || color =="Blue"){
            this.color = color;
        }else{
            this.color="Unknown";
            this.weight=0;
        }
        next=null;

    }

    public boolean hasNext(){
        if(this.next==null){
            return false;
        }else{
            return true;
        }
    }

    public String toString (){
        String tmp="";
        if(this.weight < 2.5) {
            tmp += this.color.charAt(0);
            return String.format("(%s)", tmp.toLowerCase());

        }else{
            return String.format("(%s)", this.color.charAt(0));
        }
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public Pearl getItem() {
        return item;
    }

    public void setItem(Pearl item) {
        this.item = item;
    }

    public Pearl getNext() {
        return next;
    }

    public void setNext(Pearl next) {
        this.next = next;
    }
}
