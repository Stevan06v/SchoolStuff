package com.company;

public class DriveInCinemaTicket extends CinemaTicket {

    int anzPers;

    public DriveInCinemaTicket(int price, String eventname, String ort, int time) {
        super(price, eventname, ort, time);
        this.anzPers=anzPers;
    }

    public DriveInCinemaTicket(){

    }

    @Override
    public double calculatePrice(){
        return (double) (super.calculatePrice() * anzPers);
    }

}
