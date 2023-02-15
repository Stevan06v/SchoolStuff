/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resume;

/**
 *
 * @author stevan
 */
public class Resume {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {2, 3, 412, 421323,4,2,34};
        int []inSot = insSort(arr, getSort.UP);
        for (int idx = 0; idx < arr.length; idx++) {
            Object elem = arr[idx];
            
        }
        
                for (int i = 0; i < inSot.length; i++) {
                       System.out.printf("%d, ",inSot[i]);
            
        }
        System.out.println("");
        System.out.println(binary(arr, 4213));
        System.out.println(bruteforce("Hallo wie gehts, hallo", "hallo"));
        
    }

    public static int binary(int[] arr, int needle) {
        int start = 0;
        int end = arr.length;
        while (start != end) {
            int center = start + ((end - start) / 2);
            if (needle == arr[center]) {
                return center;
            }
            if (arr[center] > needle) {
                end = center;
            } else {
                start = center + 1;
            }
        }
        return -1;
    }

    public static int bruteforce(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= needle.length()) {
            return i - needle.length();
        } else {
            return -1;
        }
    }

    public static int[] insSort(int[] arr,enum check) {
        int i, save;
        for (int j = 1; j < arr.length; j++) {
            save = arr[j];
            i = j - 1;
            while (i >= 0 && (check == check.UP) ?  (arr[i] > save) : (arr[i] < save)) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = save;
        }
        return arr;
    }

   

}
