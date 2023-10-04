import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Account implements Comparable <Account> { // only accounts can be compared

    public String name;
    public int accountNumber;
    public static double DEFAULT_INTEREST_RATE = 1.5;
    public static double DEFAULT_MAX_OVERDRAFT = -1000.00;
    private double balance;
    private double interestRate;
    private double maxOverdraft;



    public Account(int nr,double balance, double zinsen, double overdraft) {
        this.accountNumber = nr;
        this.interestRate = zinsen;
        this.maxOverdraft = overdraft;
        this.balance = balance;

    }

    public Account(int nr, double zinsen) {
        this.accountNumber = nr;
        this.DEFAULT_INTEREST_RATE = zinsen;

    }

    public Account(int nr) {
        this.accountNumber = nr;
    }

    public static Account createFromString(String s) throws AccountPersistenceException {
        //strip
        //["  34  ","  4.5  ","43  "]
        //s.strip() = "34","4.5","43"
        String arr[] = s.split(";");

        Account result = null;
        for (String iterator : arr) {
            iterator.strip();
        }
        try {

            int accountNr = Integer.parseInt(arr[0]);
            double balance = Double.parseDouble(arr[1]);
            double interestrate = Double.parseDouble(arr[2]);
            double maxoverdraft = Double.parseDouble(arr[3]);

            // [0] = nr
            // [1] = ktostd
            // [2] = zinsen
            // [3] = max overdraft

            //"4713;2500.05;0.75;-1500.00"


            if (arr.length == 4) {
                result = new Account(accountNr, interestrate);
                result.depositAmount(Double.parseDouble(arr[1]));
                result.setMaxOverdraft(Double.parseDouble(arr[3]));

            } else if (arr.length == 5) {
                result = new YouthAccount(accountNr, Integer.parseInt(arr[arr.length - 1]));
                result.depositAmount(balance);
                result.setInterestRate(interestrate);
                result.setMaxOverdraft(maxoverdraft);
            }
        } catch (Exception ex) {
            throw new AccountPersistenceException("Account specification is invalid.", ex);
        }
    return result;
    }



    @Override
    public String toString() {
        return String.format("%d; %.1f; %.1f; %.1f", this.accountNumber, this.balance, this.DEFAULT_INTEREST_RATE, this.DEFAULT_MAX_OVERDRAFT);
    }


    public double getBalance() {
        return balance;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    private void setBalance(double balance) {
        if(balance < this.maxOverdraft){
            throw new IllegalArgumentException();
        }
        this.balance = balance;
    }



    public double getInterestRate() {
        return DEFAULT_INTEREST_RATE;
    }

    public double getMaxOverdraft() {
        return DEFAULT_MAX_OVERDRAFT;
    }

    public void setMaxOverdraft(double maxOverdraft) {
        if(maxOverdraft > 0 || maxOverdraft > this.balance){
            throw new IllegalArgumentException();
        }
        this.maxOverdraft = maxOverdraft;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        if(this.accountNumber == ((Account) o).accountNumber)
            return true;
        return accountNumber == account.accountNumber && Double.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance);
    }

    public void depositAmount(double balance) {
        if(balance < this.maxOverdraft && balance < 0){
            throw new IllegalArgumentException();
        }
        this.balance += balance;
    }

    public void withdrawAmount(double value) {
        if(value < 0){
            throw new IllegalArgumentException("not < 0");
        }
        if(balance - value < this.getMaxOverdraft()){
            throw new IllegalArgumentException("Too much");
        }else{
            balance -= value;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setInterestRate(double value) {
        DEFAULT_INTEREST_RATE = value;
    }


    @Override
    public int compareTo(Account o) {

        //wenn beide elemente gleich sind = 0
        //wenn die zahl1 grösser als die zahl 2 ist dann = 1
        //wenn die zahl2 grösser als zahl1 ist dann = -1

        /*
        if(this.balance == o.balance){ //gleich 0
            return 0;
        }else if(this.balance > o.balance){ // grösser 1
            return 1;
        }else{ // kleiner -1
            return -1;
        }
*/

        // 1
        // -1
        // 0

        if(this.accountNumber == o.accountNumber){ // gleich 0
            return 0;
        }else if(this.accountNumber > o.accountNumber){ // grösser 1
            return 1;
        }else{ // kleiner -1
            return -1;
        }
    }
}
