package com.company;

public class Main {

    public static void main(String[] args) {

        // write your code here
        Mitarbeiter ma = new Mitarbeiter("Stevan", "Vlajic");
        Mitarbeiter ma2= new Mitarbeiter("Izet", "Fazlinovic");

        System.out.println(ma.tostring());
        System.out.println(ma2.tostring());

        Verwaltung pV = new Verwaltung(10);

        System.out.println(pV.addMitarbeiter(ma));
        System.out.println(pV.addMitarbeiter(ma2));

        System.out.println(pV.removeMitarbeiter(ma));
        pV.listMitarbeiter();


        Firma firma1 = new Firma("adidas","Linz", "HC Strache",pV);



    }
}
