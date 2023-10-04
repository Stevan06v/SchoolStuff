import java.util.Scanner;

public abstract class Party {
    public enum STARS{
        ONE,THREE, FIVE
    }

    STARS star;
    Scanner sc = new Scanner(System.in);
    public static final double FIXEDPRICE = 150;
    String ask;
    private boolean isDecoTypeAufwendig;
    private int snacks;
    private int getranke;
    private double zuschlag;
    private int anzVisitors;


    public Party(int snacks, int getranke, double zuschlag, int anzVisitors) {
        this.snacks = snacks;
        this.getranke = getranke;
        this.zuschlag = zuschlag;
        this.anzVisitors = anzVisitors;

        if (anzVisitors > 20) {
            System.out.print("Soll der Decotype aufwendig sein(y/n): ");
            ask = sc.nextLine();
            if (ask.equals('y')) {
                isDecoTypeAufwendig = true;
            } else {
                isDecoTypeAufwendig = false;
            }
        }
    }

    @Override
    public abstract String toString();
    public Party(double zuschlag, int anzVisitors, STARS stars) {
        this.zuschlag = zuschlag;
        this.anzVisitors = anzVisitors;
        this.star = stars;

        if (anzVisitors > 20) {
            System.out.print("Soll der Decotype aufwendig sein(y/n): ");
            ask = sc.nextLine();
            if (ask.equals('y')) {
                isDecoTypeAufwendig = true;
            } else {
                isDecoTypeAufwendig = false;
            }
        }
    }

    public abstract double calcPrice();

    public boolean isDecoTypeAufwendig() {
        return isDecoTypeAufwendig;
    }

    public int getAnzVisitors() {
        return anzVisitors;
    }

    public void setAnzVisitors(int anzVisitors) {
        this.anzVisitors = anzVisitors;
    }


    public int getSnacks() {
        return snacks;
    }

    public void setSnacks(int snacks) {
        this.snacks = snacks;
    }

    public int getGetranke() {
        return getranke;
    }

    public void setGetranke(int getranke) {
        this.getranke = getranke;
    }

    public double getZuschlag() {
        return zuschlag;
    }

    public void setZuschlag(double zuschlag) {
        this.zuschlag = zuschlag;
    }
}
