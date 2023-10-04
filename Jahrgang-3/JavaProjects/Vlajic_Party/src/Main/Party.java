package Main;

public abstract class Party {
    public enum Gala{
        ONE, TWO, THREE
    }
    int besucheranz;
    final int FIXEDPRICE = 150;
    String decoType;
    int snacks;
    int getraenke;
    double zuschlag;


    public abstract double calculatePrice();


}
