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
public class Personalverwaltung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mitarbeiter ma = new Mitarbeiter("Stevan", "Vlajic");
        Mitarbeiter ma2 = new Mitarbeiter("Huber", "Max");
        Mitarbeiter ma3 = new Mitarbeiter("Michael", "Täubel");
        Personalverwaltung1 pa = new Personalverwaltung1(10);
        System.out.println(pa.addMa(ma));
        System.out.println(pa.addMa(ma2));
        System.out.println(pa.addMa(ma3));
        System.out.println(pa.remMa(ma));
        pa.listMa();

        System.out.println(ma.toString());

        System.out.println(ma.equals(ma2));

        //man überprüft die adresse nicht verwenden
        System.out.println(ma == ma2);
        pa.listMa();

    }

}
