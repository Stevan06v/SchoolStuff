/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewue030222;

/**
 *
 * @author steva
 */    
 enum Tierart {
        HUND, KATZE;
    }

public class Tier {

    private Tierart art;
    private int gewicht;
    private String name;
    private int nr;
    private Besitzer owner;
    private static int lastNr = 0;



    public Tier(String name, int weight, Tierart art) {
        this.setNr(++lastNr);
        this.setName(name);
        this.setGewicht(gewicht);
        this.setArt(art);
    }

    public String toStirng() {
        return String.format("%s, %d, %s %s", getName(), getGewicht(), getArt(), this.owner.getName());
    }

    /**
     * @return the art
     */
    public Tierart getArt() {
        return art;
    }

    /**
     * @param art the art to set
     */
    public void setArt(Tierart art) {
        this.art = art;
    }

    /**
     * @return the gewicht
     */
    public int getGewicht() {
        return gewicht;
    }

    /**
     * @param gewicht the gewicht to set
     */
    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nr
     */
    public int getNr() {
        return nr;
    }

    /**
     * @param nr the nr to set
     */
    public void setNr(int nr) {
        this.nr = nr;
    }

    /**
     * @return the lasNr
     */
    public static int getLasNr() {
        return lastNr;
    }

    /**
     * @param aLasNr the lasNr to set
     */
    public static void setLasNr(int aLasNr) {
        lastNr = aLasNr;
    }

    /**
     * @return the owner
     */
    public Besitzer getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Besitzer owner) {
        this.owner = owner;
    }

}
