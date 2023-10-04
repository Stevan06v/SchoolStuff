/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlajic_bank;

/**
 *
 * @author steva
 */
public class Vlajic_bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String inhaber="Täubel";
        Konto k1 = new Konto();
        Konto k2 = new Konto(1000.0);
        /* Person p = new Person();*/
        
        System.out.println(k1.tostring());
        System.out.println(k2);
        System.out.println(k1.einzahlen(50));
        System.out.println(k1.abheben(0));
    }
    
}
