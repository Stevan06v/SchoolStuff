package com.company;
import vierbeiner.Hund;
import at.htl.tier.Katze;
import at.htl.tier.Tier;


public class Main {

    public static void main(String[] args) {
	// write your code here
            Tier tier = new Tier();
            tier.setName("Goofy");
            tier.setGewicht(20);
            Hund wuffi1= new Hund("wuffi", 26, 500);
            System.out.println(tier);
            System.out.println(wuffi1.toString());
            Katze miezi1 = new Katze("miezi", 5);


            System.out.println(miezi1);
            wuffi1.setName("Wuffi");
            wuffi1.setGewicht(24);
            Tier[]tiere = new Tier[]{wuffi1, miezi1};

        System.out.println("---------------------------");
        for (Tier t: tiere) {
            System.out.println(t);
        }
        System.out.println("---------------------------");

    }
}
