import java.util.LinkedHashSet;

public class Museum extends Facility{

    private LinkedHashSet<String> collectionFoci = new LinkedHashSet();

    public Museum(String name, City city, String street, int houseNumber) {
        super( name, city, street, houseNumber);

    }

    public LinkedHashSet<String> getCollectionFoci() {
        return collectionFoci;
    }

   private boolean addCollectionFocusString(String focusString){
        try {
            collectionFoci.add(focusString);
            return true;
        }catch (Exception err ){
            System.out.println(err.getCause());
        }
        return false;
   }
}
