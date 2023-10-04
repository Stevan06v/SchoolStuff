/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author steva
 */
public class Konto {

    public static double STDHABENINSEN = 0.0;
    private static int lastNr = 0;
    private double habenZinsen = 0;
    private String inhaber = "";
    private double ktoStd = 0.0;
    private int nr = 0;

    public Konto() {
        setNr(++lastNr);
    }
    
    
    public Konto(String name) {
        this();
        setInhaber(name);
    }

    //kontostand, setKontostand()
    /**
     * @param sum
     */
    public void einzahlen(int sum) {
        this.ktoStd += sum;
    }

    //
    public boolean abhebn(int sum) {
        if (ktoStd - sum < 0) {
            return false;
        } else {
            ktoStd -= sum;
            return true;
        }
    }

    public void printKontoAuszug() {
        System.out.println(getInhaber() + ", " + getKtoStd() + ", " + getNr());
    }

    /**
     * @return the STDHABENINSEN
     */
    public static double getSTDHABENINSEN() {
        return STDHABENINSEN;
    }

    /**
     * @param aSTDHABENINSEN the STDHABENINSEN to set
     */
    public static void setSTDHABENINSEN(double aSTDHABENINSEN) {
        STDHABENINSEN = aSTDHABENINSEN;
    }

    /**
     * @return the lastNr
     */
    public static int getLastNr() {
        return lastNr;
    }

    /**
     * @param aLastNr the lastNr to set
     */
    public static void setLastNr(int aLastNr) {
        lastNr = aLastNr;
    }

    /**
     * @return the habenZinsen
     */
    public double getHabenZinsen() {
        return habenZinsen;
    }

    /**
     * @param habenZinsen the habenZinsen to set
     */
    public void setHabenZinsen(double habenZinsen) {
        this.habenZinsen = habenZinsen;
    }

    /**
     * @return the inhaber
     */
    public String getInhaber() {
        return inhaber;
    }

    /**
     * @param inhaber the inhaber to set
     */
    public void setInhaber(String inhaber) {
        this.inhaber = inhaber;
    }

    /**
     * @return the ktoStd0
     */
    public double getKtoStd() {
        return ktoStd;
    }
    /**
     * @param ktoStd the ktoStd0 to set
     */
    public void setKtoStd(double ktoStd) {
        this.ktoStd = ktoStd;
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

}
