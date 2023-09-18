public class Drink implements Buyable{
    private double cupSize;
    private String name;
    private double price;

    public Drink(double cupSize, String name, double price) {
        this.cupSize = cupSize;
        this.name = name;
        this.price = price;
    }

    @Override
    public String calcName() {
        return null;
    }

    @Override
    public double calcPrice() {
        return 0;
    }
}
