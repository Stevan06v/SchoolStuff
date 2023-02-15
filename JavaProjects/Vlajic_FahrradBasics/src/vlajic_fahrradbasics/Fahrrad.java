/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlajic_fahrradbasics;

/**
 *
 * @author stevan
 */
public class Fahrrad {

    private String rahemnnr;
    private String farbe;

    public Fahrrad(String rahmennr, String farbe) {
        setRahemnnr(rahmennr);
        setFarbe(farbe);
    }

    /**
     * @return the farbe
     */
    public String getFarbe() {
        return farbe;
    }

    /**
     * @param farbe the farbe to set
     */
    public void setFarbe(String farbe) {
        if (farbe == "rot" || farbe == "grün" || farbe == "blau" || farbe == "gelb" || farbe == "weiß" || farbe == "schwarz") {
            this.farbe = farbe;

        } else {
            System.out.println("Farbe ung�ltig: Nur rot, gr�n, blau, gelb, wei� oder schwarz erlaubt!");
            this.farbe = "ungültig";
        }
    }

    /**
     * @return the rahemnnr
     */
    public String getRahemnnr() {
        return rahemnnr;
    }

    /**
     * @param rahemnnr the rahemnnr to set
     */
    public void setRahemnnr(String rahmennr) {
        if (rahmennr.length() < 3) {
            System.out.println(" Rahmennummer muss aus mindestens 3 Zeichen bestehen! & Abbruch");
            rahmennr = "ungültig";
        } else {
            this.rahemnnr = rahmennr;
        }
    }

    public String toString() {
        String nrFarbe = "Fahrrad(" + getFarbe() + " " + getRahemnnr() + ")";
        return nrFarbe;
    }

}
