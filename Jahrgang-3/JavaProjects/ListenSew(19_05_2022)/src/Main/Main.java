package Main;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //generics
        //nur Listen vom typ <...> werden genommen
        /*
        List<String> list = new List();

        list.addItem("Susi");
        list.addItem("Hans");
        list.addItem(new Person("Max", "Muster", 3));

        String name  = (String)(list.getFirst())
         */
        try{
            calc();
        }catch (NullPointerException npe){
            System.out.println("Da war eine null...");
        }

    }
    public static int calc(){
        Object o =null;
        if(o.toString().equals("blabla")){
            System.out.println("kann nicht funktionieren");
        }

        return 1;
    }
}
