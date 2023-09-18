package com.company;

public class Main {

    public static void main(String[] args) {

        Ticket[] tickets = new Ticket[10];
        System.out.println("---------------------------------------------------------------------------------------");


        tickets[0] = new CinemaTicket(60, "Hallo Welt", "Linz", 40);
        System.out.println(tickets[0].printTicket());
        tickets[1]= new ConcertTicket(89, "Hallo CINEMA TICKET", "linz", "9");
        System.out.println(tickets[1].printTicket());

        System.out.println(printAll(tickets));
        System.out.println("Endbetrag: "+calculateSum(tickets));

        // test
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(tickets[0].printTicket());
        DriveInCinemaTicket t1 = new DriveInCinemaTicket(50, "Linz", "Hallo WElt", 500);
        ConcertTicket t2 = new ConcertTicket(50, "Linz", "Hallo WElt", "8");
        System.out.println(t1.calculatePrice());
        System.out.println(t2.calculatePrice());
        System.out.println(t2.printTicket());
    }

    public static String printAll(Ticket[] tickets) {
        String returnValue = "";
        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i] !=null){
                returnValue += tickets[i].printTicket()+"\n";
            }
        }
        return returnValue;
    }

    public static double calculateSum(Ticket[] tickets){
        double erg=0;
        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i]!=null){
               erg+= tickets[i].calculatePrice();
            }
        }
        return (double)(erg);
    }

}
