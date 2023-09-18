public class FoodPacked extends Food{
    private double price;

    public FoodPacked() {}

    @Override
    public String calcName() {
        return "null";
    }

    @Override
    public double calcPrice() {
        return price;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
