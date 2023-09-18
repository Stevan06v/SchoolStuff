import java.util.Objects;

public class Account implements Comparable <Account> { // only accounts can be compared

    public String name;
    public int accountNumber;
    public static double DEFAULT_INTEREST_RATE = 1.5;
    public static double DEFAULT_MAX_OVERDRAFT = -1000.0;
    private double balance;



    public Account(int nr, double zinsen) {
        this.accountNumber = nr;
        this.DEFAULT_INTEREST_RATE = zinsen;
    }

    public Account(int nr) {
        this.accountNumber = nr;
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
    public void setBalance(double balance) {
        this.balance = balance;
    }



    public double getInterestRate() {
        return DEFAULT_INTEREST_RATE;
    }

    public double getMaxOverdraft() {
        return DEFAULT_MAX_OVERDRAFT;
    }

    public void setMaxOverdraft(double v) {
        if(v > 0){
            throw new IllegalArgumentException("muss > 0 sein");
        }else{
            DEFAULT_MAX_OVERDRAFT = v;
        }

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

    public void depositAmount(double value) {
        if(value < 0){
            throw new IllegalArgumentException("darf nicht < 0 sein");
        }else {
            balance += value;
        }
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
