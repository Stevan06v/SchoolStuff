package at.htlleonding.bank;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    private final static int PORT = 7777;
    public static void main(String[] args) throws IOException {
        System.out.println("SERVER: Starting.");

        AccountManager accountManager = new AccountManager();

        try(ServerSocket socketServer = new ServerSocket(PORT)) {
            while(true) {
                System.out.println("SERVER: Listening for a connection.");

                Socket socketClient = socketServer.accept();
                System.out.println("SERVER: Connection accepted.");

                Thread thread = new Thread(new BankServerWorker(accountManager, socketClient));
                thread.start();
            }
        }
        catch (Exception e) {
            System.out.println("SERVER: Oh oh.");
            e.printStackTrace();
        }

        System.out.println("SERVER: Finished.");
    }
}
