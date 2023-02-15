package com.company;

public class Mitarbeiter {
     private String vorname;
     private String nachname;
     private int id;
     static int lastNr = 0;

     public Mitarbeiter(String vorname, String nachanem){
        this.setVorname(vorname);
        this.setNachname(nachanem);
        this.setId(++lastNr);
     }

     public String toString(){
         return String.format("%03d %s, %s", getId(), getNachname(),getVorname());
         #+++










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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
