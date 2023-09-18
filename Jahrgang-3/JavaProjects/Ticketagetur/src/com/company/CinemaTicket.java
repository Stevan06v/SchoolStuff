package com.company;

public class CinemaTicket extends Ticket {

    int filmlaegne;
    public CinemaTicket(int price, String eventname, String ort, int laenge){
        super(price, eventname, ort);
        this.filmlaegne = laenge;
    }

    public CinemaTicket(){

    }


    public double calculatePrice(){
        int erg=(int)(getPrice());
        if (filmlaegne > 150 ){
            erg = (int)(getPrice()) + 3;
        }
        return (double)(erg) ;
    }
}