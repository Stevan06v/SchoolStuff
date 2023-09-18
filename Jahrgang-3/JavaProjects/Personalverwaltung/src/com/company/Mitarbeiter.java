package com.company;

enum Tiere{
    HUND,KATZE;
}

public class Mitarbeiter {
    private String vorname;
    private String nachname;
    int id;
    static int lastNr=0;


    public Mitarbeiter(String vorname, String nachname){
        setNachname(nachname);
        setVorname(vorname);
        this.id = lastNr++;
    }

    public  String tostring(){
        return String.format("%04d %s, %s", this.id, getVorname(), getNachname());
    }


    public boolean equals(Mitarbeiter ma){
        if(ma.getVorname().equals(this.getVorname()) && ma.getNachname().equals(this.getNachname()) && ma.id== this.id){
            return true;
        }
        return false;
    }

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
}
