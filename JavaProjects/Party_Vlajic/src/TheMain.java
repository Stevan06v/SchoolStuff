
public class TheMain {
    public static void main(String[] args) {

        PartyManager pm = new PartyManager();
        BirthdayParty b = new BirthdayParty(32, 32, 40, 12);
        DinnerParty d = new DinnerParty(23, 20, Party.STARS.ONE);


        System.out.println(pm.addParty(b));
        //System.out.println(pm.addParty(d));

        System.out.println(d.calcPrice());


        System.out.println(pm.calculatPrice() + "EUR");
        pm.printParties();
    }
}
