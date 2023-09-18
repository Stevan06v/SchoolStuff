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
public class Firmenbuchnr {

    Unternehmen[] unternehmen;

    public Firmenbuchnr(int maxAnz) {
        unternehmen = new Unternehmen[maxAnz];
    }

    public Firmenbuchnr() {
        unternehmen = new Unternehmen[10];
    }

    public static final String generateFbnr(int lfdNr) {
        String ziffern = String.format("%06s", lfdNr);
        
        int sum = ziffern.charAt(0) - '0' * 4
                + ziffern.charAt(0) - '0' * 14
                + ziffern.charAt(0) - '0' * 15
                + ziffern.charAt(0) - '0' * 10
                + ziffern.charAt(0) - '0' * 1;
        
        sum = sum % 17;
        char[] letters = {'A', 'B', 'C', 'D', 'F', 'G', 'H', 'I', 'K', 'M', 'P', 'U', 'B', 'P'};
        return "" + lfdNr + letters[sum];
    }

    public boolean add(Unternehmen unterhenmen) {
        for (int i = 0; i < this.unternehmen.length; i++) {
            if (this.unternehmen[i] == null || this.unternehmen[i].getFnr() == unternehmen.getFnr()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean removeUnternehmen(String fbnr) {
        for (int i = 0; i < unternehmen.length && this.unternehmen[i] != null; i++) {
            if (this.unternehmen[i].getFnr() == fbnr) {
                //löschen
                for (int j = i; j < unternehmen.length - 1; j++) {
                    this.unternehmen[j] = unternehmen[j + 1];
                }
            }
            this.unternehmen[unternehmen.length - 1] = null;
            return true;
        }
        return false;
    }

    public String toString() {
        String result = "";
        for (Unternehmen u : this.unternehmen) {
            if (u != null) {
                result +="\n"+unternehmen;
            }
        }
        return result;
    }
    
    
}
