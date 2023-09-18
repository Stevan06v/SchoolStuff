package com.company;

public class Ticket {
    private double price = 50;
    private String eventname;
    private String ort;

    public Ticket(int price, String eventname, String ort ){
        this.price = price;
        this.eventname = eventname;
        this.ort = ort;
    }

    public Ticket() {

    }

    public double calculatePrice() {
        return (double)(price);
    }
    public String printTicket() {
        return "Ticketagentur{" +
                "price=" + price +
                ", eventname='" + eventname + '\'' +
                ", ort='" + ort + '\'' +
                '}';
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
