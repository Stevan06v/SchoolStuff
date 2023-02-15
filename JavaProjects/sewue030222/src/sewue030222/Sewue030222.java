/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewue030222;
/**
 *
 * @author stevan
 */
public class Sewue030222 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tier bello = new Tier("Bello", 3500, Tierart.HUND);
        Tier miezi =  new Tier ("Miezi", 5000,  Tierart.KATZE);
       
        Besitzer max = new Besitzer("Max");
        miezi.setOwner(max);
        max.kauft(bello);
        
        System.out.println(bello.toStirng());
        
        
    }
    
}
