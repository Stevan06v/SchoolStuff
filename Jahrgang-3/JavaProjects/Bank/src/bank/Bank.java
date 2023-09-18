/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author stevan
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Konto[] kontos = new Konto[10];
        /*
        for (int i = 0; i < kontos.length; i++) {
            kontos[i]= new Konto();
        }
         */
        kontos[0] = new Konto("Stevan Vlajic");
        kontos[0].einzahlen(1000);
        kontos[0].abhebn(100);
        kontos[0].printKontoAuszug();
        String a = "Hallo Welt";
        System.out.println(a.substring(2, 4));
        System.out.println();
        System.out.println(Math.abs(5 - 9));
    }

    public int[] insSort(int[] arr) {
        int i = 0;
        int save = 0;
        for (int j = 1; j < arr.length; j++) {
            save = arr[j];
            i = j - 1;
            while (i >= 0 && arr[i] > save) {
                arr[i+1]=save;
                i--;
            }
            arr[i+1]=save;
        }
        return arr;
    }
}
