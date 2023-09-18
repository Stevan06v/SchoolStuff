/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalverwaltung;

/**
 *
 * @author stevan
 */
public class Personalverwaltung1 {

    Mitarbeiter[] ma;

    public Personalverwaltung1(Mitarbeiter[] ma) {
        this.ma = ma;
    }

    public Personalverwaltung1(int anz) {
        ma = new Mitarbeiter[anz];
    }

    public void listMa() {
        String saveMa = "";
        for (int i = 0; i < ma.length; i++) {
            if (ma[i] != null) {
                System.out.println(ma[i].toString());
            } else {
                System.out.println("null");
            }
        }
    }

    public boolean addMa(Mitarbeiter ma) {
        for (int i = 0; i < this.ma.length; i++) {
            if (this.ma[i] == null) {
                this.ma[i] = ma;
                return true;
            }
        }
        return false;
    }

    public boolean remMa(Mitarbeiter ma) {
        for (int i = 0; i < this.ma.length; i++) {
            if (this.ma[i] != null && this.ma[i].equals(ma)) {
                this.ma[i] = null;
                for (int j = i; j < this.ma.length - 1; j++) {
                    this.ma[j] = this.ma[j + 1];
                    this.ma[this.ma.length - 1] = null;
                }

                return true;
            }
        }
        return false;
    }

    public void sort() {
        
    }

}
