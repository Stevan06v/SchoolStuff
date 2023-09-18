/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resumeone;

/*
 * @author stevan
 */
public class ResumeOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TODO code application logic here
        int[] arr = {1, 22, 34, 21, 4, 21, 4, 231};
        int[] insSort = insSort(arr);
        String txt = "wie gehts dir hallo, hallo ";
        String needle = "hallo";
        int tmp = 0;
        fori
        for (int i = 0; i < txt.length(); i++) {
            int bruteforce = bruteforce1(needle, txt, i);
            if (bruteforce >-1 && bruteforce!=tmp) {
                System.out.println(bruteforce1(txt, needle, i));
            }
            tmp = bruteforce;
        }

        System.out.println(binaryRec(4, 0, insSort.length, insSort));
        System.out.println(bruteforce("hallo", "wie gehts dir hallo"));

    }

    public static int[] insSort(int[] arr) {
        int i, save;
        for (int j = 1; j < arr.length; j++) {
            save = arr[j];
            i = j - 1;
            while (i >= 0 && arr[i] > save) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = save;
        }
        return arr;
    }

    public static int bruteforce1(String haystack, String needle, int i) {

        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (needle.charAt(j) == haystack.charAt(j)) {
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

    public static int binarySearch(int[] arr, int needle) {
        int start = 0;
        int end = arr.length;
        while (start != end) {
            int center = start + ((end - start) / 2);
            if (arr[center] == needle) {
                return center;
            }
            if (arr[center] > end) {
                end = center - 1;
            } else {
                start = center + 1;
            }
        }
        return -1;
    }

    public static int binaryRec(int needle, int start, int end, int[] arr) {
        if (start > end) {
            return -1;
        }
        int center = start + ((end - start) / 2);
        if (needle == arr[center]) {
            return center;
        } else if (arr[center] > end) {
            return binaryRec(needle, start, center - 1, arr);
        } else {
            return binaryRec(needle, center + 1, end, arr);
        }
    }

    public static int linearSearch(int[] arr, int needle) {
        int i = 0;
        while (i < arr.length && arr[i] != needle) {
            i++;
        }
        if (i > arr.length) {
            return -1;
        } else {
            return i;
        }
    }

    public static int bruteforce(String needle, String haystack) {
        int i = 0;
        int j = 0;
        while (j < needle.length() && i < haystack.length()) {
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

}
