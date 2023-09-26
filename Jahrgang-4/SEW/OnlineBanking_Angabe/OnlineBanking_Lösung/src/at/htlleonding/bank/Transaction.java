package at.htlleonding.bank;

import java.io.Serializable;
import java.math.BigInteger;

public class Transaction implements Serializable {
    private String iban;
    private double amount;

    public String getIban() {
        return iban;
    }

    private final void setIban(String iban) {
        if(!isValidIban(iban)) {
            throw new IllegalArgumentException();
        }
        this.iban = iban;
    }

    public double getAmount() {
        return amount;
    }

    public Transaction(String iban, double amount) {
        this.setIban(iban);
        this.amount = amount;
    }

    public static boolean isValidIban(String iban) {
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

    @Override
    public String toString() {
        return String.format("%s: %.2f,-", this.iban, this.amount);
    }
}
