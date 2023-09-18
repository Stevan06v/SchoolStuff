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


        // im try wird ein neues Objekt erstellt, welches CLOSEABLE ist. dieses wird automatisch abgebrochen
        try (ServerSocket serverSocket = new ServerSocket(6013)){
            // durch die unendlichkeitsschleife rennt der server duchgehend und ist immer erreichbar
            for(;;){
                String name = "";

                // auf client wird gewartet
                Socket client = serverSocket.accept();
                // input stream von client
                scClient = new Scanner(client.getInputStream());
                scSystem = new Scanner(System.in);

                // Output stream is the console
                // Schickt nach jedem schreiben die naxhricht weiter
                PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true);

                printWriter.println(new Date().toString());
                printWriter.println("Hallo du! Wie heißt du?");
                String input =  scClient.nextLine();
                name = input;
                System.out.println(input);

                printWriter.println("Hallo "+ input + "! wie geht es dir? Beende die Kommunikation mit [quit]!");


                while (!input.equalsIgnoreCase("quit")){
                    System.out.println("input");
                    printWriter.println(scSystem.nextLine());
                    input = scClient.next();
                }

                System.out.print(String.format("%s left the chat", name));

                client.close();
            }
        }catch(IOException ex){

            System.out.println(ex);
        }

    }
}
