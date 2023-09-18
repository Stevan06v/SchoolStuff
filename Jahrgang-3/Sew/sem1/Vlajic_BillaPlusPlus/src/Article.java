public abstract class Article implements Comparable<Article>{

    private String articleName;
    private int barcode = 0;
    private int quantity;


    public Article(String articleName, int barcode, int quantity){
        this.articleName = articleName;
        this.barcode = barcode;

        if(quantity >= 0) this.quantity = quantity;
        else this.quantity = 0;

    }

    //29582143

    public static boolean checkBarcode(int barcode) {
        // 0 1 2 3 4 5 6 7
        if (barcode+"".length() == 7) {
            String strBarcode = (barcode + "").substring(0, 7);
            int odd = 0;
            int even = 0;

            for (char iterator : strBarcode.toCharArray()) {
                int currValue = Integer.parseInt(iterator + "");
                if (currValue % 2 == 0) even += currValue;
                else odd += currValue;
            }

            int checksum = (10 - ((3 * odd + even) % 10)) % 10;

            if (strBarcode.charAt(barcode + "".length()) == checksum) {
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
    }

    public int compareTo(Article o){
        return Integer.compare(this.getQuantity(), o.getQuantity());
    }
    public String getArticleName() {
        return articleName;
    }

    public int getBarcode() {
        return barcode;
    }

    public int getQuantity() {
        return quantity;
    }


}