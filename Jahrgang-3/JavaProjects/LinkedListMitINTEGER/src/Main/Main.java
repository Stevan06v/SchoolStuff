package Main;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // object wird im heap angelegt
        //generics

        List<Integer> noten = new LinkedList<>();
        noten.add(1);
        int i = 5;
        Integer i2 = Integer.valueOf(i);

        System.out.println(i2);

        List<Integer> intList = new LinkedList<>();

        //objekt wird angelegt
        intList.add(5);

        //wird von objct zu prim datentyp umgewandelt
        int summe = 3 + intList.get(0);
        System.out.println(summe);


        int numb= 5;
        int sum = square(numb);
        System.out.println(sum);

    }
    public static int square(Integer i){
        return i * i;
    }
}
