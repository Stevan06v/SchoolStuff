package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Mitarbeiter[] mas= new Mitarbeiter[10];

        //keine instanzierungne moeglich
        //Mitarbeiter m = new Mitarbeiter();

        mas[0]= new InternerMitarbeiter("dsff","dfa", 30000);
        mas[1]= new ExternerMitarbeiter("dsff","dfa", 12, 900);
        InternerMitarbeiter ma=new InternerMitarbeiter("dsff","dfa", 30000);
        int sum=0;

        System.out.println(mas[0].toString());

        for (int i = 0; i < mas.length; i++) {
            if(mas[i]!=null){
               sum += mas[i].calculatePrice();
                System.out.println(mas[i].calculatePrice());
            }
        }
        System.out.println(sum);
        //oder
        Mitarbeiter[]mas2= new Mitarbeiter[]{
               ma
        };
    }
}
