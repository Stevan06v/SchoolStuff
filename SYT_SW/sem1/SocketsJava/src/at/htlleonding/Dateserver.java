package at.htlleonding;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Dateserver {

    public static void main(String[] args) {


        // im try wird ein neues Objekt erstellt, welches CLOSEABLE ist. dieses wird automatisch abgebrochen
        try (ServerSocket serverSocket = new ServerSocket(6013)){
            // durch die unendlichkeitsschleife rennt der server duchgehend und ist immer erreichbar
            for(;;){
                // auf client wird gewartet
                Socket client = serverSocket.accept();

                // Output stream is the console
                // Schickt nach jedem schreiben die naxhricht weiter
                PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true);

                printWriter.println(new Date().toString());

                client.close();
            }
        }catch(IOException ex){
            System.out.println("Connection Failed");
        }


    }
}
