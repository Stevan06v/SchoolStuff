/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlajic_rationalezahlen;

/**
 *
 * @author steva
 */
public class Rational {

    private int zaehler = 0;
    private int nenner = 0;

    public Rational(int zaehler, int nenner) {
        this.nenner = nenner;
        this.zaehler = zaehler;
    }

    Rational() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int ggT(int a, int b) {
        if (a == b || b == 0) {
            return a;
        } else {
            return ggT(b, a % b);
        }
    }

    public String kuerzen(int nenner, int zaehler, int ggT) {
        nenner = nenner / ggT;
        zaehler = zaehler / ggT;

        return  nenner + "/" + zaehler;
    }

    public void setNenner(int nenner) {
        this.nenner = nenner;
    }

    public void setZeahler(int zaehler) {
        this.zaehler = zaehler;
    }

    public String mul(int zahler, int nenner) {
        int newZ = this.zaehler * zahler;
        int newN = this.nenner * nenner;
        return newZ + "/" + newN;
    }

    public String div(int zahler, int nenner) {
        int newZ = this.zaehler * nenner;
        int newN = this.nenner * zahler;
        return newZ + "/" + newN;
    }

    //add funk
    public String add(int zahler, int nenner) {
        int z;
        if (this.nenner == nenner) {
            z = this.zaehler + zahler;
            return z + "/" + nenner;
        } else {
            if (this.nenner > nenner) {
                while (this.nenner != nenner) {
                    nenner++;
                    zahler++;
                }
                z = this.zaehler + zahler;
                return z + "/" + nenner;
            } else {
                while (this.nenner != nenner) {
                    this.nenner++;
                    this.zaehler++;
                }
                z = this.zaehler + zahler;
                return z + "/" + nenner;
            }
        }
    }
    //sub funk

    public String sub(int zahler, int nenner) {
        int z;
        if (this.nenner == nenner) {
            z = this.zaehler - zahler;
            return z + "/" + nenner;
        } else {
            if (this.nenner > nenner) {
                while (this.nenner != nenner) {
                    nenner++;
                    zahler++;
                }
                z = this.zaehler - zahler;
                return z + "/" + nenner;
            } else {
                while (this.nenner != nenner) {
                    this.nenner++;
                    this.zaehler++;
                }
                z = this.zaehler - zahler;
                return z + "/" + nenner;
            }
        }
    }

    public String toString() {
        return zaehler + "/" + nenner;
    }

}
