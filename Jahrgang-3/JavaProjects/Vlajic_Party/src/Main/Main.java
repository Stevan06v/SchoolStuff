package Main;

public class Main {

    public static void main(String[] args) {
	// write your code here

        PartyManager p = new PartyManager();
        BirthdayParty b= new BirthdayParty(10);
        b.setAnzGetraenke(2);
        System.out.println( p.addParty(b));
        p.printList();
    }
}
