package com.company;

public abstract class Mitarbeiter {
    private String vorname;
    private String nachname;
    private int tage;
    public Mitarbeiter(){}

    public Mitarbeiter(String vorname, String nachname, int tage) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.tage = tage;
    }



    //calculate Price von jedem Mitarbeiter
    public String toString(){
        return String.format("%s %s %2d Tage, %d €",vorname, nachname, tage, calculatePrice());
    }

    //override nicht in eltern
    /*
    public int calculatePrice(){
        return 0;
    }
    */

    public abstract int calculatePrice();

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getTage() {
        return tage;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }
}
