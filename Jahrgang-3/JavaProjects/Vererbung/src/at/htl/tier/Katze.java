package at.htl.tier;
import at.htl.tier.Tier;

//hund erbt von tier
public class Katze extends Tier {

    public Katze(String name, double gewicht){
        // super ruft konstruktor von der darüberliegenden klasse auf
        super(name, gewicht);

        
    }
}
