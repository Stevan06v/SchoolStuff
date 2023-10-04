public abstract class Food implements Buyable{
    @Override
    public abstract String calcName();

    @Override
    public double calcPrice() {
        return 0;
    }
}
