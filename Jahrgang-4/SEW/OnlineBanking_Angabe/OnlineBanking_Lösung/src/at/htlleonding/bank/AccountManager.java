package at.htlleonding.bank;

import java.io.Serializable;
import java.util.HashMap;

public class AccountManager implements Serializable {
    private HashMap<String, Double> accounts;

    public AccountManager() {
        this.accounts = new HashMap<>();
    }

    public synchronized boolean performTransaction(Transaction transaction) {
        if(!this.accounts.containsKey(transaction.getIban())) {
            this.accounts.put(transaction.getIban(), transaction.getAmount());
            return true;
        }

        if(this.accounts.get(transaction.getIban()) + transaction.getAmount() < 0.0) {
            return false;
        }

        this.accounts.put(transaction.getIban(), this.accounts.get(transaction.getIban()) + transaction.getAmount());
        return true;
    }

    public double getBalanceForAccount(String iban) throws AccountNotFoundException {
        if(!this.accounts.containsKey(iban)) {
            throw new AccountNotFoundException();
        }
        return this.accounts.get(iban);
    }
}
