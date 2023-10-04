package com.company;

public class Firma {
    
    private String firmename;
    private String firmensitz;
    private Verwaltung pV;
    private String inhaber;


    public Firma(String firmename, String firmensitz, String inhaber, Verwaltung pV){
        setInhaber(inhaber);
        setFirmename(firmename);
        setFirmensitz(firmensitz);
        setpV(pV);
    }

    public String toString(){
        return String.format("Mitarbeiter der Firma %s: \n %s ", getFirmename(), this.pV.listMitarbeiterString());
    }


    public String getFirmename() {
        return firmename;
    }

    public void setFirmename(String firmename) {
        this.firmename = firmename;
    }

    public String getFirmensitz() {
        return firmensitz;
    }

    public void setFirmensitz(String firmensitz) {
        this.firmensitz = firmensitz;
    }

    public Verwaltung getpV() {
        return pV;
    }

    public void setpV(Verwaltung vW) {

        this.pV = vW;
    }

    public String getInhaber() {
        return inhaber;
    }

    public void setInhaber(String inhaber) {
        this.inhaber = inhaber;
    }
}
