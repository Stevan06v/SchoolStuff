package org.example;
import java.net.Socket;


public class BankServerWorker implements Runnable{
    private final AccountManager accountManager;
    private final Socket socketClient;

    public BankServerWorker(AccountManager accountManager, Socket socketClient) {
        this.accountManager = accountManager;
        this.socketClient = socketClient;
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {

    }
}
