package at.htlleonding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;
import java.util.Date;
import java.util.Scanner;

public class ChatClient {
    public static Scanner scSocket = null;
    public static Scanner scSystem = null;
    public static PrintWriter out;
    public static BufferedReader in;
    public static final String host  = "localhost";
    public static int port = 6013;

        public static void main(String[] args) {


            // im try wird ein neues Objekt erstellt, welches CLOSEABLE ist. dieses wird automatisch abgebrochen
            try (Socket clientSocket = new Socket(host, port)){

                String input="";
                Scanner sc = new Scanner(System.in);

                out = new PrintWriter(clientSocket.getOutputStream());
                scSocket = new Scanner(clientSocket.getInputStream());

                while (!input.equalsIgnoreCase("quit") && !clientSocket.isClosed()){
                    if(!input.equalsIgnoreCase("quit") && !clientSocket.isClosed())input = scSocket.nextLine();
                    System.out.println(input);
                    out.println(scSocket.nextLine());
                }
                out.println(input);

                Scanner inputScanner = new Scanner(System.in);

                //Schicke Namen
                String inputFromConsole  = inputScanner.nextLine();
                out.println(inputFromConsole);
                //lese nächste Aufforderung vom server

                System.out.println(scSocket.nextLine());
                out.println("quit");
                clientSocket.close();

            }catch(IOException ex){
                System.out.println("Connection Failed");
            }

        }



}
