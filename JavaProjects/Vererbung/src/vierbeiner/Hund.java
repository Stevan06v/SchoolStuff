package vierbeiner;

import at.htl.tier.Tier;

//hund erbt von tier
public class Hund extends Tier {

   private int beisskraft;
    public Hund(String name, double gewicht, int beisskraft){
        // super ruft konstruktor von der darüberliegenden klasse auf
        super(name, gewicht);
        this.beisskraft = beisskraft;
    }


    @Override
    public String toString() {
        return String.format("%s: \nGewicht: %.0fkg\nBeisskraft: %d kg", getName(), getGewicht(), getBeisskraft());
    }


    public int getBeisskraft() {
        return beisskraft;
    }

    public void setBeisskraft(int beisskraft) {
        this.beisskraft = beisskraft;
    }
}
