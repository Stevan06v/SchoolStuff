package at.htlleonding.bank;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    private final static String IP_ADDRESS = "127.0.0.1";
    private final static int PORT = 7777;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String iban = null;
        boolean isValid = false;
        while(!isValid) {
            System.out.println("Please enter your IBAN: ");
            iban = scanner.nextLine();

            if(Transaction.isValidIban(iban)) {
                System.out.println("Valid IBAN entered.");
                isValid = true;
            }
            else {
                System.out.println("Invalid IBAN entered. Please try again.");
            }
        }

        try (Socket socketClient = new Socket(IP_ADDRESS, PORT)) {
            try (BufferedReader streamInput = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
                 ObjectOutputStream streamOutput = new ObjectOutputStream(socketClient.getOutputStream())) {

                boolean isRunning = true;
                while(isRunning) {
                    System.out.print("Enter amount for new transaction (or \"quit\" to quit the application): ");
                    String amountRaw = scanner.nextLine();

                    if(amountRaw.equals("quit")) {
                        streamOutput.writeObject(null);
                        isRunning = false;
                    }
                    else {
                        try {
                            Transaction transaction = new Transaction(iban, Double.valueOf(amountRaw));

                            streamOutput.writeObject(transaction);

                            String response = streamInput.readLine();

                            System.out.println("Response from server: " + response);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Number not formatted correctly.");
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            System.out.println("CLIENT: Oh oh.");
            ex.printStackTrace();
        }
    }
}
