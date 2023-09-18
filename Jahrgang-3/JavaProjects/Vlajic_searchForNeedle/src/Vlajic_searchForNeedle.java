import java.util.Scanner;
public class Vlajic_searchForNeedle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String haystack = haystack();// haystack = text for searching
        String needle;// needle = searching user Input in the haystack=text
        int pos;
        int temp = -1;
        String returnVlaue;

        System.out.println("The haystack is: ");
        System.out.println(haystack());
        do {
            
            System.out.println("----------------Start-----------------");
            System.out.print("Needle: ");
            needle = sc.nextLine();
            needle=needle.toLowerCase();//
            if(needle != ""){//verm v. komp outp des Str
                for (int i = 0; i < haystack.length(); i++){
                    pos = findNeedleInHaystack(needle, haystack, i);
                    if (pos > -1 && temp != pos ){//verm. v. err u. wh outp von wort
                    returnVlaue = haystack.substring(pos, Math.min(pos + 6, haystack.length()));
                    System.out.println( pos + ": " + returnVlaue + "..." );
                    //break;
                    }
                    temp = pos;
                }
            //6 = 6 stellen danach
            System.out.println("-----------------End------------------");
            System.out.println("");
            }
            //end loop
        } while (needle != "");
        //haystack return
        }


    public static int findNeedleInHaystack(String needle, String haystack, int pos) {
        //i=3
        int j = 0;
        // haystack=hallo
        // needle=h
        while (pos < haystack.length() && j < needle.length()) {
            if (needle.charAt(j) == haystack.charAt(pos)) {
                pos++;// i=1
                j++;// j=1
            } else {
                pos = pos - j + 1;// i=1//i=2//i=3//i=4//i=5
                j = 0; // j=0//j=0//j=0//j=0//j=0
            }
        }
        if(j >= needle.length()){
            return pos - needle.length();
        }else{
            return -1;
          }
        }
    // text as method to short the main
    public static String haystack() {
        return "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.".toLowerCase();
    }



}
