package Main;

public class BirthdayParty extends Party{

    boolean bigCake;

    public BirthdayParty(int count){
        super.besucheranz = count;
        super.getraenke = count;
        super.snacks = count;
        if(count > 10 && count <= 20 ){
            super.zuschlag = 10;
            bigCake = false;

        }else if(count > 20){
            super.zuschlag = 30;
            bigCake = true;
        }else{
            super.zuschlag = 30;
            bigCake = true;
        }
    }

    public String getDecorationType(){
        if(super.besucheranz > 0   || super.besucheranz <= 20){
            super.decoType = "LOW";
            return super.decoType;
        }else if(super.besucheranz > 20 || super.besucheranz <= 40 ){
            super.decoType = "MID";
            return super.decoType;
        }else {
            super.decoType = "HIGH";
            return super.decoType;
        }
    }

    @Override
    public double calculatePrice() {
        double price = 0;
        if(super.besucheranz > 10){
            if(bigCake == true){
                price = super.FIXEDPRICE + besucheranz + 6 * super.snacks + 7 * super.getraenke + super.zuschlag +  40;
            }else{
                price = super.FIXEDPRICE + besucheranz + 6 * super.snacks + 7 * super.getraenke + super.zuschlag + 20;
            }
        }else {
            if(bigCake == true){
                price = super.FIXEDPRICE + besucheranz + 6 * super.snacks + 7 * super.getraenke +  40;
            }else{
                price = super.FIXEDPRICE + besucheranz + 6 * super.snacks + 7 * super.getraenke + 2;
            }
        }
        return price;
    }

    @Override
    public String toString() {
        return "BirthdayParty{" +
                "Personen='" + super.besucheranz+"'"+
                ", decoType='" + this.getDecorationType() + '\'' +
                ", snacks=" + super.snacks +
                ", getraenke=" + super.getraenke +
                ", zuschlag=" + super.zuschlag +
                '}';
    }

    public void setAnzSnacks(int snacks){
        super.snacks = snacks;
    }
    public void setAnzGetraenke(int getraenke){
        super.getraenke = getraenke;
    }
}
