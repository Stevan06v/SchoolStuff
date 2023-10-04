package at.htlleonding.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class MainNumbers {
    public static void main(String[] args) {
        List<Integer> myNumbers = List.of(new Integer[] {2, 13, 6, 36, 13, 26, 7, 47, 2, 18, 5, 45, 7});

        //Calculate the product of all numbers:
        int product = myNumbers
                .stream()
                .reduce((integer, integer2) -> integer * integer2)
                .get(); //TODO

        assertEquals(2031106176, product);

        //Calculate the sum of unique numbers:
        int sumUniqueNumbers = myNumbers
                .stream()
                .distinct()
                .reduce(Integer::sum)
                .get(); //TODO

        assertEquals(205, sumUniqueNumbers);

        //Find the largest of the first six numbers:
        int maxOfFirstSeven = myNumbers
                .stream()
                .mapToInt(iterator -> iterator).limit(6)
                .max().getAsInt(); //TODO

        assertEquals(36, maxOfFirstSeven);

        //Count the odd numbers:
        long countOdd=myNumbers
                .stream()
                .filter(iterator -> iterator % 2 != 0)
                .count(); //TODO

        assertEquals(7L, countOdd);

        //Check whether there is _any_ number divisible by 15:
        boolean isAnyNumberDivisibleByFifteen = myNumbers
                .parallelStream()
                .anyMatch(integer -> integer % 15 == 0) ; //TODO

        assertEquals(true, isAnyNumberDivisibleByFifteen);

        //Check whether _all_ of the first seven numbers are smaller than 30:
        boolean areFirstSevenSmall = myNumbers
                .stream()
                .limit(7)
                .allMatch(iterator -> iterator < 30); //TODO

        assertEquals(false, areFirstSevenSmall);

        //Calculate the mean of the first 5 numbers:
        double meanOfFirstFive = myNumbers
                .stream()
                .limit(5)
                .mapToDouble(iterator -> iterator)
                .average()
                .getAsDouble(); //TODO

        assertEquals(14.0, meanOfFirstFive);

        //Save all values below 20 followed by a '%' sign to a list:
        List<String> smallValues = myNumbers
                .stream()
                .filter(iterator -> iterator < 20)
                .map(iterator -> iterator.toString() + "%")
                .toList(); //TODO

        assertEquals("[2%, 13%, 6%, 13%, 7%, 2%, 18%, 5%, 7%]", smallValues.toString());

        //Print all unique values smaller than 20 in a sorted manner, divided by whitespaces:
        //TODO
        //Output: 2 5 6 7 13 18
        myNumbers
                .stream()
                .filter(iterator -> iterator < 20)
                .distinct()
                .sorted()
                .map(iterator -> iterator + " ")
                .forEach(System.out::print);
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
