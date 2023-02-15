/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlajic_fahrradbasics;

/**
 *
 * @author stevan
 */
public class Vlajic_FahrradBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        Schueler hans, peter;
        Fahrrad rad;

        hans = new Schueler("Hans", "Moser", "Musterweg 21", "A-4020", "Linz");
        System.out.println(hans.toString()); // Schueler(Hans,Moser,Musterweg 21,A-4020,Linz)

        peter = new Schueler("Peter", "Pan", "Limesstr. 11", "A-4600", "Leonding");
        System.out.println(peter); // Schueler(Peter,Pan,Limesstr. 11,A-4600,Leonding)

        peter.whgWechsel("Limesstr. 31", "A-4060", "Leonding");
        System.out.println(peter); // Schueler(Peter,Pan,Limesstr. 31,A-4060,Leonding)

        System.out.println();

        rad = new Fahrrad("001", "rot");
        System.out.println(rad); // Fahrrad(001,rot)

        /*
    rad = new Fahrrad();
    geht nicht

    rad = new Fahrrad(null, "gelb");
    Rahmennummer muss aus mindestens 3 Zeichen bestehen!

    rad = new Fahrrad("", "gelb");
    Rahmennummer muss aus mindestens 3 Zeichen bestehen!

    rad = new Fahrrad("1","gelb");
    Rahmennummer muss aus mindestens 3 Zeichen bestehen! & Abbruch

    rad = new Fahrrad("001", "t�rkis");
    Farbe ung�ltig: Nur rot, gr�n, blau, gelb, wei� oder schwarz erlaubt!
         */
        System.out.println();
        System.out.println("Nach Rahmennummer sortieren ...");

        Fahrrad[] bikes = new Fahrrad[5];

        bikes[0] = new Fahrrad("003", "rot");
        bikes[1] = new Fahrrad("005", "gelb");
        bikes[2] = new Fahrrad("002", "weiß");
        bikes[3] = new Fahrrad("001", "schwarz");
        bikes[4] = new Fahrrad("005", "grün");
        System.out.println("Bike: " + bikes[0]);
        System.out.println("-------------------");
        sort(bikes);
        System.out.println("-------------------");

        /*
    Fahrrad(001,schwarz)
    Fahrrad(002,wei�)
    Fahrrad(003,rot)
    Fahrrad(005,gelb)
    Fahrrad(005,gr�n)
         */
    } // main

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static void sort(Fahrrad[] radl) {
        //get kennzeichen
        int[] arr = new int[radl.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(radl[i].getRahemnnr());
        }
        
        // sort kennzeichen
        for (int i = 1; i < radl.length; i++) {
            for (int j = 0; j < radl.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, i, j);
                }
            }
        }
        // set Kennzeichen
        for (int i = 0; i < arr.length; i++) {
            radl[i].setRahemnnr("00" + arr[i]);
        }
        // print out Kennzeichen
        for (int i = 0; i < arr.length; i++) {
            System.out.println(radl[i]);
        }
        
    } 
}
