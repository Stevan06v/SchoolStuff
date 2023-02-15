package com.company;

public class Konto {

    public static double STDHABENZINSEN;
    private static int lasNr=0;
    private double habenZinsen;
    private String inhaber;
    private double ktoStd;
    private int nr;

    public Konto(String inhaber){
        setInhaber(inhaber);
        nr = ++lasNr;
    }


    public String printKontoAuszug(){
        return String.format("%04f: %s:\n %f", getNr(), getInhaber(),getKtoStd()
        );
    }

    public double getHabenZinsen() {
        return habenZinsen;
    }

    public void setHabenZinsen(double habenZinsen) {
        this.habenZinsen = habenZinsen;
    }

    public String getInhaber() {
        return inhaber;
    }

    public void setInhaber(String inhaber) {
        this.inhaber = inhaber;
    }

    public double getKtoStd() {
        return ktoStd;
    }

    public void setKtoStd(double ktoStd) {
        this.ktoStd = ktoStd;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }
}
