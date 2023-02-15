package Main;

public class PartyManager {
    Party[] party = new Party[10];

    public boolean addParty(Party p){
        for (int i = 0; i < party.length; i++) {
            if(party[i] == null){
                party[i]= p;
                return true;
            }
        }
        return false;
    }

    public void printList(){
       int c=0;
        while(c < party.length ){
            if(party[c]!=null){
                System.out.println(
                        party[c].toString()+"\n"
                );
            }
            c++;
        }
    }


}
