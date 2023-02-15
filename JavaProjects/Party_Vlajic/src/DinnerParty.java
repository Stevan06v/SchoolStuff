import static java.math.BigInteger.ONE;

public class DinnerParty extends Party {

    public DinnerParty(double zuschlag, int anzVisitors, STARS stars) {
        super(zuschlag, anzVisitors, stars);
    }

    @Override
    public double calcPrice() {
        double price = 0;
        if(super.star.equals(STARS.ONE)){
            price = super.FIXEDPRICE + super.getZuschlag();
        }else if(super.star.equals(STARS.THREE)){
            price = super.FIXEDPRICE + super.getZuschlag() + 250;
        }else if(super.star.equals(STARS.FIVE)){
            price = super.FIXEDPRICE + super.getZuschlag() + 450;
        }
        return price;
    }


    @Override
    public String toString() {
        return "DinnerParty{" +
                "star=" + star +
                "zuschlag=" + super.getZuschlag() +
                "visitors=" + super.getAnzVisitors() +
                '}';
        }
}
