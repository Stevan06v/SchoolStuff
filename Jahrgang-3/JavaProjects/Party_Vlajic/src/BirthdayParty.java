
public class BirthdayParty extends Party {

    private boolean isBigCake;

    public BirthdayParty(int snacks, int getranke, double zuschlag, int anzVisitors) {
        super(snacks, getranke, zuschlag, anzVisitors);
        if (anzVisitors > 20) {
            isBigCake = true;
        } else {
            isBigCake = false;
        }
    }

    @Override
    public String toString() {
        return "BirthdayParty{" +
                "isBigCake=" + isBigCake +
                ", snacks=" + super.getSnacks() +
                ", getraenke=" + super.getGetranke() +
                ", zuschlag=" + super.getZuschlag() +
                ", zuschlag=" + super.getAnzVisitors() +
                '}';
    }

    @Override
    public double calcPrice() {
        double price = 0;
        if (isBigCake == true) {
            price = super.FIXEDPRICE + 50 + super.getGetranke() * 2 + super.getSnacks() * 2;
        } else if(super.isDecoTypeAufwendig()){
            price=  super.FIXEDPRICE + super.getGetranke() * 2 + 160 + super.getSnacks() * 2;
        } else if(isBigCake == false ) {
            price = super.FIXEDPRICE + super.getGetranke() * 2 + super.getSnacks() * 2;
        }

        return price;
    }


}
