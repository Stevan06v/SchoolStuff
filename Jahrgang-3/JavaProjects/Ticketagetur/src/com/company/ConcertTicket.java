package com.company;

public class ConcertTicket extends Ticket{

    String sitzPos="";

    public ConcertTicket(int price, String eventname, String ort, String sitzPos){
        super(price, eventname, ort);
        this.sitzPos = sitzPos;
    }

    public ConcertTicket(){
    }

    @Override
    public double calculatePrice(){
        return (double) (getPrice() + getPrice() / Double.parseDouble(sitzPos));
    }


}
