package at.htlleonding.bank;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class BankServerWorker implements Runnable {
    private final AccountManager accountManager;
    private final Socket socketClient;

    public BankServerWorker(AccountManager accountManager, Socket socketClient) {
        this.accountManager = accountManager;
        this.socketClient = socketClient;
    }

    @Override
    public void run() {
        System.out.println("SERVER-THREAD: Starting.");

        try (this.socketClient) {
            try (ObjectInputStream streamInput = new ObjectInputStream(socketClient.getInputStream());
                 PrintWriter streamOutput = new PrintWriter(socketClient.getOutputStream(), true)) {

                Transaction transaction;
                while((transaction = (Transaction) streamInput.readObject()) != null) {
                    System.out.printf("SERVER-THREAD: Received object \"%s\".%n", transaction);

                    boolean isSuccess = accountManager.performTransaction(transaction);

                    if(!isSuccess) {
                        streamOutput.println("Transaction unsuccessful.");
                    }
                    else {
                        double balance = accountManager.getBalanceForAccount(transaction.getIban());
                        streamOutput.printf("Transaction successful. New balance: %.2f.%n", balance);
                    }
                }
                System.out.println("SERVER-THREAD: Received null. Finishing.");
            }
        } catch (Exception e) {
            System.out.println("SERVER-THREAD: Oh oh.");
            throw new RuntimeException(e);
        }

        System.out.println("SERVER-THREAD: Finished.");
    }
}
