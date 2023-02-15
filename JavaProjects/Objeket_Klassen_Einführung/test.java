public class test {
    public static void main(String[] args) {
    }
   public void sitzplaetze(int anz){
        if(anz>7){
            System.out.println("Zu viele...");
            sitzplaetze=7;
        }else{
            sitzplaetze=anz;
        }
   }

}
