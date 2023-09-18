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
public class Vlajic_RationaleZahlen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rational rNumbs = new Rational(6, 3);
        System.out.println("ggT: " + rNumbs.ggT(6, 3));
        System.out.println("multiply: " + rNumbs.mul(8, 1));
        System.out.println("div: " + rNumbs.div(5, 1));
        System.out.println("add: " + rNumbs.add(4, 18));
        System.out.println("sub: " + rNumbs.sub(5, 11));
        System.out.println("kuerz: " + rNumbs.kuerzen(6,3, rNumbs.ggT(6, 3)));

    }

}
