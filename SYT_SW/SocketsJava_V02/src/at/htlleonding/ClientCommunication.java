package at.htlleonding;

import sun.net.www.protocol.file.FileURLConnection;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import static at.htlleonding.ChatServer.scClient;

public class ClientCommunication implements Runnable{
    private Socket clientSocket;


    public ClientCommunication(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        System.out.println("[run]: running...");
        try{

            // input stream von client
            scClient = new Scanner(clientSocket.getInputStream());
            Scanner scSystem = new Scanner(System.in);
            PrintWriter pout = new PrintWriter(clientSocket.getOutputStream(), true);




        // Output stream is the console
        // Schickt nach jedem schreiben die nachricht weiter


        pout.println(new Date().toString());
        pout.println("Hallo du! Wie heißt du?");
        String input =  scClient.nextLine();


        String name = input;
        System.out.println(input);

        pout.println("Hallo "+ input + "! wie geht es dir? Beende die Kommunikation mit [quit]!");

        while (!input.equalsIgnoreCase("quit")){
            System.out.println(input);
            pout.println(scSystem.nextLine());
            input = scClient.next();
        }

            System.out.print(String.format("%s left the chat", name));

        clientSocket.close();
        }catch (Exception err){
            err.printStackTrace();
        }

    }

}
