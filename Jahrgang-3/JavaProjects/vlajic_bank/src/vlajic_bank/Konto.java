/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlajic_bank;

/**
 *
 * @author stevan
 */
public class Konto {

    public static final double STDHABENZINSEN = 0.1;
    private static int lastNr = 0;
    private double habenZinsen;
    private int nr;
    private String inhaber;
    private double ktoStd = 0;

    public Konto() {
        this.nr = ++lastNr;
        this.inhaber= inhaber;
    }

    public Konto(double money) {
        this();//Konto wird aufgerufen 

    }
    public void setInhaber(String owner){
        this.inhaber=owner;
    }
    
 public void setHabenZinsen(double zins){
        this.habenZinsen=zins;
    }
    
    public boolean abheben(double betrag) {
        if (betrag < 0 || betrag > this.ktoStd) {
            return false;
        } else {
            this.ktoStd -= betrag;
            return true;
        }
    }

    public boolean einzahlen(double betrag) {
        if (betrag <= 0) {
            return false;
        }
        this.ktoStd += betrag;
        return true;
    }



    public String tostring() {
        return "Konto {\n" + "nr: " + nr + "\nKontostand: " + ktoStd + "\nInhaber: "+inhaber+"\n}";
    }
}
