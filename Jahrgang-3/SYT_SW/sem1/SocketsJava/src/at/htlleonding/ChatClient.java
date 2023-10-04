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
    public static Scanner scClient = null;
    public static Scanner scSystem = null;
    public static PrintWriter out;
    public static BufferedReader in;
    public static final String host  = "localhost";
    public static int port = 6013;

        public static void main(String[] args) {



            String input = "";
            try(Socket clientSocket = new Socket(host, port)){

                Scanner scSocket = new Scanner(clientSocket.getInputStream());

                Scanner scSys = new Scanner(System.in);

                PrintWriter pout = new PrintWriter(clientSocket.getOutputStream(), true);


                while (!input.equalsIgnoreCase("quit") && !clientSocket.isClosed()){

                    if(!input.equalsIgnoreCase("quit") && !clientSocket.isClosed())input = scSocket.nextLine();

                    System.out.println(input);
                    pout.println(scSys.nextLine());
                }
                scSocket.close();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }



}
