package at.htlleonding.demo;

public class Account {
    private String iban;
    private double balance;

    public String getIban() {
        return iban;
    }

    public String getCensoredIban() {
        return this.iban.substring(0,4) + "..." + this.iban.substring(16);
    }

    public double getBalance() {
        return balance;
    }

    public Account(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double withdraw(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException();
        }
        double result = Math.min(amount, this.balance);
        this.balance = Math.max(0, this.balance - amount);
        return result;
    }
}
