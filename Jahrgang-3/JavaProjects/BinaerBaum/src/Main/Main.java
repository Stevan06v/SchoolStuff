package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        Random rd = new Random();
/*
        BinaryTree binaryTree= new BinaryTree();
        Node node1 = new Node(2);

        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(12);
        binaryTree.add(32);
        binaryTree.printTree();

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Hallo Welt");
        System.out.println(map.get(1));
        System.out.println(map.containsKey(1));
        for (Map.Entry e:
             map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
*/
        int []arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(10) +  3 ;
        }
        System.out.println("-----------------------------");
        System.out.println("Dupes: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length ; j++) {
               if(arr[i] == arr[j]){
                   System.out.print(arr[j]+", ");
               }
            }
        }

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+", ");
        } System.out.println("-----------------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }



}
