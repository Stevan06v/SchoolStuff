package org.example;

import java.io.Serializable;
import java.util.HashMap;

public class AccountManager implements Serializable {
    private HashMap<String, Double> accounts;

    public AccountManager() {
        this.accounts = new HashMap<String, Double>();
    }

    public synchronized boolean performTransaction(Transaction transaction){
            if (transaction.getAmount() < 0 ){
                return false;
            }

            if (!accounts.containsKey(transaction.getIban())) {
                accounts.put(transaction.getIban(), transaction.getAmount());
                return true;
            }else{
                String iban = transaction.getIban();
                this.accounts.replace(iban,this.accounts.get(iban),this.accounts.get(iban) + transaction.getAmount());
            }
            if(this.accounts.get(transaction.getIban()) - transaction.getAmount() < 0){
                return false;
            }else{
                return true;
            }

    }
    public double getBalanceForAccount(String iban) throws AccountNotFoundException{
        if (!this.accounts.containsKey(iban)){
            throw new AccountNotFoundException("Account does not exist!");
        }else{
            return this.accounts.get(iban);
        }
    }
}
