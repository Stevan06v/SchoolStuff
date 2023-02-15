public class FoodOpen extends Food{
    private double pricePerUnit;
    private double unit;

    public FoodOpen() {}

    @Override
    public String calcName() {
        return null;
    }

    @Override
    public double calcPrice() {
         return pricePerUnit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

}
