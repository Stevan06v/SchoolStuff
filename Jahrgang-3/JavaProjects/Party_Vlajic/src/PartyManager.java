import org.w3c.dom.ls.LSParser;

import java.util.LinkedList;
import java.util.List;

public class PartyManager {
    Party[] party = new Party[10];

    public boolean addParty(Party p){
        for (int i = 0; i < this.party.length; i++) {
            if(this.party[i] == null){
                this.party[i] = p;
                return true;
            }
        }
        return false;
    }

    public double calculatPrice(){
        double sum= 0;
        for (int i = 0; i < this.party.length; i++) {
            if(this.party[i] != null){
                sum += this.party[i].calcPrice();
            }
        }
        return sum;
    }

    public void printParties(){
        for (int i = 0; i < this.party.length; i++) {
            if(this.party[i] != null){
                System.out.println(this.party[i].toString());
            }
        }
    }


}
