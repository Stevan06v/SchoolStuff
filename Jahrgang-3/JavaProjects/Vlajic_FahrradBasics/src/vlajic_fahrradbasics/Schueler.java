/**
 * Informationenn zu einem Schueler
 */
package vlajic_fahrradbasics;

/**
 *
 * @author stevan
 */
public class Schueler {

    private String vorname;
    private String nachname;
    private String strasse;
    private String plz;
    private String ort;

    public Schueler(String vorname, String nachname, String strasse, String plz, String ort) {
        setVorname(vorname);
        setNachname(nachname);
        setAdresse(strasse, ort, plz);
    }

    public void setAdresse(String strasse, String ort, String plz) {
        setStrasse(strasse);
        setOrt(ort);
        setPlz(plz);
        /**
         * Weist dem Schüler eine neue Adresse zu
         *
         * @param strasse besteht aus Strassenname, ort un dplz
         */
    }

    /**
     * @return the vorname
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    /**
     * @return the nachname
     */
    public String getVorname() {
        return vorname;
    }
    /**
     * @return the nachname
     */
    public String getNachname() {
        return nachname;
    }
    /**
     * @param nachname the nachname to set
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    /**
     * @return the strasse
     */
    public String getStrasse() {
        return strasse;
    }
    /**
     * @param strasse the strasse to set
     */
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    /**
     * @return the plz
     */
    public String getPlz() {
        return plz;
    }
    /**
     * @param plz the plz to set
     */
    public void setPlz(String plz) {
        this.plz = plz;
    }
    /**
     * @return the ort
     */
    public String getOrt() {
        return ort;
    }
    /**
     * @param ort the ort to set
     */
    public void setOrt(String ort) {
        this.ort = ort;
    }

    void whgWechsel(String plz, String strasse, String ort) {
        if (plz == "" && ort == "" && strasse == "") {
            System.out.println("Wohnung nicht vorhanden!");
        } else {
            setPlz(plz);
            setStrasse(strasse);
            setOrt(ort);
        }
    }

    public String toString() {
        return getVorname() + " " + getNachname() + " " + getStrasse() + " "+ getPlz() + " "+ getOrt();
    }

}
