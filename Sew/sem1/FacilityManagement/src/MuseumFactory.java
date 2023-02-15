import javax.security.auth.kerberos.KerberosTicket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MuseumFactory implements FacilityFactory{

     public  Facility createFromString(String s){

         FacilityRepository repo = FacilityRepository.getInstance();
         try {
             Museum museum = null;
             String name;
             int zip_code;


             String street;
             int house_number;

             String [] attr = s.split(";");

             for (String iterator: attr) {
                 iterator.strip();
             }

             name = attr[0];
             street = attr[1];
             house_number = Integer.parseInt(attr[2]);

             zip_code = Integer.parseInt(attr[3]);


             //String name, City city, String street, int houseNumber
             museum = new Museum(name, repo.createCityIfNotExists(zip_code, name), street, house_number);

             String [] focies = attr[4].split(",");
             for (String iterator : focies) {
                 iterator.strip();
                 museum.addCollectionFocus(iterator);
             }

             return museum;

         }catch (Exception err){
             throw new FacilityManagementException(err);
         }


     }


}
