package com.company;

public class ExternerMitarbeiter extends Mitarbeiter {
    double tagsatz;
    int tage= 5;

    public ExternerMitarbeiter(String vorname, String nachname, int tage, int tagsatz){
        super(vorname, nachname, tage);
        this.tagsatz=tage;
    }

    @Override
    public int calculatePrice(){
        return (int)(tagsatz * tage);
    }

}
