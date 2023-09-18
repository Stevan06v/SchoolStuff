package at.htlleonding.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainAlphabet {
    public static void main(String args[]) {
        List<String> myStrings = Arrays.asList("abc", "defg", "", "hi", "jklm", "n", "", "op", "qrstu", "v", " ", "wxyz", "");

        //Count the empty (and blank) strings:
        long countEmptyStrings = myStrings
                .stream()
                .filter(iterator -> iterator.equals(""))
                .count();

        assertEquals(3L, countEmptyStrings);

        System.out.println("First passed!");

        //Count the strings with a length greater than 2:
        long countLongStrings = myStrings
                .stream()
                .filter(iterator -> iterator.length() > 2)
                .count(); //TODO

        assertEquals(5L, countLongStrings);

        System.out.println("Second passed!");

        //Count the number of strings which end with 'g', 'i' or 'n':
        long countEndingWithGin = myStrings
                .stream()
                .filter(iterator ->
                        iterator.endsWith("g") ||
                        iterator.endsWith("i") ||
                        iterator.endsWith("n")
                )
                .count(); //TODO

        assertEquals(3L, countEndingWithGin);

        System.out.println("Third passed!");

        //Remove all empty (and blank) strings and store the result in a new list:
        List<String> myNonEmptyStrings = myStrings
                .stream()
                .filter(iterator -> !iterator.equals("") && !iterator.equals(" "))
                .toList()
                ; //TODO

        assertEquals("[abc, defg, hi, jklm, n, op, qrstu, v, wxyz]", myNonEmptyStrings.toString());

        System.out.println("Fourth passed!");


        //Convert all non-blank strings in the list to uppercase and join them using dashes (without using String.join ;):
        String joinedAndUppered = myStrings.stream().filter(s -> s != "" && s != " ").toList().toString().toUpperCase()
                .replace(',', '-')
                .replace(" ", "")
                .replace("[", "")
                .replace("]", "");

        assertEquals("ABC-DEFG-HI-JKLM-N-OP-QRSTU-V-WXYZ", joinedAndUppered);


        System.out.println("Fifth passed!");

        //Calculate the total length of all strings excluding whitespaces in the list:
        long totalLength = myStrings
                .stream()
                .filter(iterator -> !iterator.equals("") && !iterator.equals(" "))

                .count()

                ; //

        assertEquals(26, totalLength);

        System.out.println("Sixth passed!");

        //Calculate the sum of ASCII values of the first letters of each non-blank string:
        int sumInitialsAscii = -1; //TODO
        assertEquals(978, sumInitialsAscii);

        //Create a string containing the sorted lengths of all strings:
        String sortedLengths = "TODO";
        assertEquals("0001112234445", sortedLengths);

        //Create a list containing only strings longer than than 3 letters:
        List<String> longStrings = null; //TODO
        assertEquals("[defg, jklm, qrstu, wxyz]", longStrings.toString());

        //Create a list with all non-blank strings "surrounded" by $-signs:
        List<String> dollarStrings = null; //TODO
        assertEquals("[$abc$, $defg$, $hi$, $jklm$, $n$, $op$, $qrstu$, $v$, $wxyz$]", dollarStrings.toString());

        //Create a string containing the initials of all non-empty strings:
        String initials = "TODO";
        assertEquals("adhjnoqvw", initials);

        //Print the second letter of each string as long as the string has at least 2 characters:
        //TODO
        //Output: beikprx
    }

    public static void assertEquals(Object expected, Object actual) {
        if(expected instanceof Double) {
            if((double)actual < (double)expected - 0.01 || (double)expected + 0.01 < (double)actual) {
                throw new RuntimeException(String.format("Expected \"%f\" but received \"%f\" instead!", expected, actual));
            }
        }
        else if(expected == null && actual != null) {
            throw new RuntimeException(String.format("Expected null but received \"%s\" instead!", actual));
        }
        else if(expected != null && !expected.equals(actual)) {
            throw new RuntimeException(String.format("Expected \"%s\" but received \"%s\" instead!", expected, actual));
        }
    }
}
