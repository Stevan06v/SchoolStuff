package org.example;

import java.io.Serializable;
import java.math.BigInteger;

public class Transaction implements Serializable {

    private String iban;
    private double amount;

    public Transaction(String iban, double amount) throws RuntimeException {
       this.setIban(iban);
       this.setAmount(amount);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f,-", this.iban, this.amount );
    }
    public static boolean isValidIban(String iban){
        try {
            String ibanClean = iban.replaceAll(" ", "");

            String ibanRearranged = ibanClean.substring(4) + ibanClean.substring(0, 4);

            String ibanReplaced = "";

            for (char currChar : ibanRearranged.toCharArray()) {
                if (Character.isLetter(currChar) && Character.isUpperCase(currChar)) {
                    ibanReplaced += currChar - 'A' + 10;
                } else {
                    ibanReplaced += currChar;
                }
            }

            BigInteger ibanDigitized = new BigInteger(ibanReplaced);
            int rest = ibanDigitized.mod(new BigInteger("97")).intValue();
            if (rest == 1) {
                return true;
            }
        }
        catch (Exception e) {

        }

        return false;
    }
    public String getIban() {
        return iban;
    }

    public double getAmount() {
        return amount;
    }
    private void setIban(String iban) throws IllegalArgumentException{
        if(!isValidIban(iban)){
            throw new IllegalArgumentException("Invalid IBAN given.");
        }
        this.iban = iban;
    }
    private void setAmount(double amount) throws IllegalArgumentException {
        this.amount = amount;

    }
}
