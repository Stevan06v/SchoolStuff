package Main;

public class Dinnerparty extends Party{

    boolean isGalaDinner;

    public Dinnerparty(boolean isGalaDinner) {
        this.isGalaDinner = isGalaDinner;
        if(isGalaDinner == true){

        }else{

        }

    }



    @Override
    public double calculatePrice() {
        return 0;
    }

}
