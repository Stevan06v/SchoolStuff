package com.company;

public class InternerMitarbeiter extends Mitarbeiter {
    double gehalt;

    public InternerMitarbeiter(String vorname, String nachname,  int monatgehalt){
        super(vorname, nachname, monatgehalt);
        this.gehalt=monatgehalt;
    }



    @Override
    public int calculatePrice(){
        return (int)(gehalt/20);
    }


}
