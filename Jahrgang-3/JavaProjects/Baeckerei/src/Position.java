public class Position {
    private double amount;


    private Cart cart = new Cart();

    public Position() {
    }

    public Position(double amount) {
        this.amount = amount;
    }
    
    public double calcPrice(){
        double sum=0;
        for (int i = 0; i < this.cart.content.size(); i++) {
            sum += this.cart.getValue();
        }
        return sum;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
