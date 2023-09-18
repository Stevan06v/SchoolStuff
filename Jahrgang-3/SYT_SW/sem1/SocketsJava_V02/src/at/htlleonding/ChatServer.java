package at.htlleonding;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ChatServer {
    public static Scanner scClient = null;
    public static Scanner scSystem = null;
    public static void main(String[] args) {


        System.out.println("Server wird gestartet!");
        // im try wird ein neues Objekt erstellt, welches CLOSEABLE ist. dieses wird automatisch abgebrochen
        try (ServerSocket serverSocket = new ServerSocket(6013)){

            // durch die unendlichkeitsschleife rennt der server duchgehend und ist immer erreichbar
            while(true) {

                // auf client wird gewartet
                Socket client = serverSocket.accept();

                System.out.println("Client wurde angenommen" + new Date().toString());
                ClientCommunication communication = new ClientCommunication(client);


                Thread  thread = new Thread(communication);

                thread.start();
                System.out.println("[thread]: running... :)");

            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        System.out.println("thread ended.");

    }
}
