package at.htlleonding.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(9, 10, -3, 4, 7, 3, 4);

        //Find the first even number:
        Integer firstEven = numbers.stream().filter(n -> n % 2 == 0).findFirst().get();
        assertEquals(10, firstEven);

        //Count the positive numbers:
        long countPositiveNumbers = numbers.stream().filter(n -> n > 0).count();
        assertEquals(6L, countPositiveNumbers);

        //Create a list of all unique squares:
        List<Integer> distinctSquares = numbers.stream().map(n -> n * n).distinct().collect(Collectors.toList());
        assertEquals("[81, 100, 9, 16, 49]", distinctSquares.toString());

        //Print them using sequential and parallel streams:
        System.out.println("Unique squares (sequential):");
        distinctSquares.stream().forEach(System.out::println);
        System.out.println("Unique squares (parallel):");
        distinctSquares.parallelStream().forEach(System.out::println);

        //Get the sum of the three largest squares (and print them for debugging purposes):
        int sum = distinctSquares.stream().
                sorted((n, o) -> Integer.compare(o, n)).
                limit(3).
                peek(n -> System.out.printf("["+n + "]")).
                mapToInt(Integer::intValue).
                sum();
        assertEquals(230, sum);

        //Let's do the same (without printing) for the mean, min, and max of the three largest squares:
        double average = distinctSquares.stream().sorted((n, o) -> Integer.compare(o, n)).limit(3).mapToInt(Integer::intValue).average().getAsDouble();
        assertEquals(76.666667, average);
        int min = distinctSquares.stream().sorted((n, o) -> Integer.compare(o, n)).limit(3).mapToInt(Integer::intValue).min().getAsInt();
        assertEquals(49, min);
        int max = distinctSquares.stream().sorted((n, o) -> Integer.compare(o, n)).limit(3).mapToInt(Integer::intValue).max().getAsInt();
        assertEquals(100, max);

        //Calculate the digit sum of all but the first three squares:
        int digitSum = distinctSquares.stream().skip(3).reduce(0, (a,b) -> {
            while(b > 0) {
                a += b % 10;
                b /= 10;
            }
            return a;
        });
        assertEquals(20, digitSum);

        System.out.println("\n----------");

        //Read accounts from file:
        Stream<String> fileStream = null;
        try {
            fileStream = Files.lines(Paths.get("data/accounts.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Account> accounts = fileStream.
                map(s -> s.split(";")).
                map(c ->  {
                    return new Account(c[0], Double.valueOf(c[1]));
                }).collect(Collectors.toList());

        //Get the average balance:
        double balanceAverage = accounts.stream().mapToDouble(a -> a.getBalance()).average().getAsDouble();
        assertEquals(178063.86125000002, balanceAverage);

        //Calculate the charges if everyone has to pay 5%:
        double taxes = accounts.stream().map(a -> a.getBalance()).reduce(0.0, (a,b) ->  a += b * 0.05);
        assertEquals(71225.5445, taxes);

        //Check if everyone has less than a million on their account:
        boolean isEveryoneBelowMillion = accounts.stream().allMatch(a -> a.getBalance() < 1_000_000);
        assertEquals(true, isEveryoneBelowMillion);

        //Everyone wins the lottery!
        accounts.stream().forEach(a -> a.deposit(100_000));

        //Check if someone has more than half a million:
        boolean isSomeoneAboveHalfMillion = accounts.stream().anyMatch(a -> a.getBalance() > 500_000);
        assertEquals(true, isSomeoneAboveHalfMillion);

        //Create a string containing the first and last 4 symbols of each IBAN, separated by commas:
        String ibansCensored = accounts.stream().map(a -> a.getIban().substring(0,4) + "..." + a.getIban().substring(16)).collect(Collectors.joining(","));
        assertEquals("AT02...9870,AT02...7558,AT02...1605,AT02...7144,AT02...9660,AT02...8597,AT02...2634,AT02...3800", ibansCensored);

        //Do the same as above using a method reference:
        ibansCensored = accounts.stream().map(Account::getCensoredIban).collect(Collectors.joining(","));
        assertEquals("AT02...9870,AT02...7558,AT02...1605,AT02...7144,AT02...9660,AT02...8597,AT02...2634,AT02...3800", ibansCensored);

        //Print the account information of all accounts sorted by their balance:
        accounts.stream().
                sorted((a, b) -> Double.compare(b.getBalance(), a.getBalance())).
                map(a -> String.format("%s: %.2f", a.getIban(), a.getBalance())).
                forEach(System.out::println);
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