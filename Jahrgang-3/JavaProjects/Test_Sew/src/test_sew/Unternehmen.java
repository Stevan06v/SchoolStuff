/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_sew;

/**
 *
 * @author steva
 */
public class Unternehmen {

    private String fnr;
    private static int counter = 0;
    private  int lfn=0;
    private String bezeichnung;
    private String rechtsform;
    private String anschrift;
    
    

    public Unternehmen(String fnr, String bezeichung, String rechtsform, String anschrift) {
        //this();
        this.lfn = ++counter;
        this.anschrift=anschrift;
        this.rechtsform=rechtsform;
        this.anschrift=anschrift;
    }
    

    public String toString() {
        return String.format("%7s: %s, %s, %s,  ", getFnr(), getBezeichnung(), getRechtsform(), getAnschrift());
    }

    
    /**
     * @return the fnr
     */
    public String getFnr() {
        return this.fnr;
    }
    /**
     * @param fnr the fnr to set
     */
    public void setFnr(String fnr) {
        this.fnr = fnr;
    }
    
    /**
     * @return the bezeichnung
     */
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * @param bezeichnung the bezeichnung to set
     */
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    /**
     * @return the rechtsform
     */
    public String getRechtsform() {
        return rechtsform;
    }

    /**
     * @param rechtsform the rechtsform to set
     */
    public void setRechtsform(String rechtsform) {
        this.rechtsform = rechtsform;
    }

    /**
     * @return the anschrift
     */
    public String getAnschrift() {
        return anschrift;
    }

    /**
     * @param anschrift the anschrift to set
     */
    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

}
