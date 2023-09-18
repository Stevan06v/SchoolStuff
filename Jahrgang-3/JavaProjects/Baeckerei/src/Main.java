import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[]args) {

        List<String> namesListe = new LinkedList();

        namesListe.add("Susi");
        namesListe.add("Hans");

        System.out.println(namesListe.toString());

        for (String l:namesListe) {
            System.out.println(l);
        }

        Drink drink = new Drink(67, "l", 1.67);



    }
}
