import java.util.*;

public class Main {
    public static void main(String[] args) {

        Account acc = new YouthAccount(231, 16);
        acc.depositAmount(500);

        System.out.println(acc.getBalance());



        Account acc3 = new YouthAccount(213, 3);
        acc3.setBalance(34);


        Account acc1 = new Account(3344,0.1);
        Account acc2 = new Account(3344,0.1);
        acc1.setBalance(200);
        acc2.setBalance(100);
        acc1.name = "Stevan";
        acc2.name = "Max";

        //liste vom typen account
        List <Account> list = new ArrayList<>();
        list.add(acc1);
        list.add(acc2);

        System.out.println("vorher");
        for (Account iterator:
             list) {
            System.out.println(iterator.getBalance());
        }
        Collections.sort(list);
        System.out.println("nachher");
        for (Account iterator:
                list) {
            System.out.println(iterator.getBalance());
        }

        System.out.println("----------------");

        Account acc4 = new Account(432, 4);
        Account acc5 = new Account(4332, 44);

        acc5.setBalance(3000);
        acc4.setBalance(1250);

        List<Account> list2 = new LinkedList();

        list2.add(acc4);
        list2.add(acc5);



        AccountBookAmountComparator comparator = new AccountBookAmountComparator();

        Collections.sort(list2, comparator);

        for (Account iterator:
             list2) {
            System.out.println(iterator.getAccountNumber());
        }




    }
}
