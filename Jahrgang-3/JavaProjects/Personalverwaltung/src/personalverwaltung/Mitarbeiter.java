/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalverwaltung;

/**
 *
 * @author steva
 */
public class Mitarbeiter {

    private static int lastNr = 0;
    private int lfdNr = 0;
    private String vn;
    private String nn;

    public Mitarbeiter() {
        setLfdNr(++lastNr);
    }

    public Mitarbeiter(String vn, String nn) {
        this();
        setVn(vn);
        setNn(nn);
    }

    public String toString() {
        return "Mitarbeiter{\n"
                + String.format("%04d,\n%s,\n%s,\n", getLfdNr(), getVn(), getNn())
                + "}";
    }

    public boolean equals(Mitarbeiter ma) {
        if (nn.equals(ma.getNn()) && vn.equals(ma.getVn()) && ma.getLfdNr() == this.getLfdNr()) {
            return true;
        } else {
            return false;
        }
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
     * @return the vn
     */
    public String getVn() {
        return vn;
    }

    /**
     * @param vn the vn to set
     */
    public void setVn(String vn) {
        this.vn = vn;
    }

    /**
     * @return the nn
     */
    public String getNn() {
        return nn;
    }

    /**
     * @param nn the nn to set
     */
    public void setNn(String nn) {
        this.nn = nn;
    }

    /**
     * @return the lfdNr
     */
    public int getLfdNr() {
        return lfdNr;
    }

    /**
     * @param lfdNr the lfdNr to set
     */
    public void setLfdNr(int lfdNr) {
        this.lfdNr = lfdNr;
    }

}
