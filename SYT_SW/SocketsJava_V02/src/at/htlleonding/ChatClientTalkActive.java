package at.htlleonding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientTalkActive {
    public static Scanner scClient ;
    public static Scanner scSystem = new Scanner(System.in);

    public static BufferedReader in;
    public static final String host  = "localhost";
    public static int port = 6013;

        public static void main(String[] args) {
            String input = "";
            // im try wird ein neues Objekt erstellt, welches CLOSEABLE ist. dieses wird automatisch abgebrochen
            try (Socket clientSocket = new Socket(host, port)){

                Scanner sc = new Scanner(System.in);

                scClient= new Scanner(clientSocket.getInputStream());
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream());



                Scanner inputScanner = new Scanner(System.in);

                //Schicke Namen
                input = inputScanner.nextLine();

                //lese nächste Aufforderung vom server
                out.println(input);


                System.out.println(scClient.nextLine());

                while(!input.equals("quit")){
                    input = scClient.nextLine();
                    out.println(input);
                    System.out.println(scClient.nextLine());
                    input = sc.nextLine();
                    out.println(input);
                }


                clientSocket.close();

            }catch(IOException ex){
                System.out.println("Connection Failed");
            }

        }



}
