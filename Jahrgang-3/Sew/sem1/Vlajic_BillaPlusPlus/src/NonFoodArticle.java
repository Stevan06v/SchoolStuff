
public class NonFoodArticle extends Article{


    private int warrantyMonths;

    public NonFoodArticle(String articleName, int barcode, int quantity, int warrantyMonths) {
        super(articleName, barcode, quantity);

        if(warrantyMonths >= 0) this.warrantyMonths = warrantyMonths;
        else this.warrantyMonths = 0;


    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}
