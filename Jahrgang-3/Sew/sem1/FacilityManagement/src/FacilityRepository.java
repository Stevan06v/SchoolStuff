import java.io.File;
import java.io.PipedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class FacilityRepository {

    private TreeMap<Integer, City> cities= new TreeMap<>();

    private TreeSet<Facility> facilities = new TreeSet<>();

    private static FacilityRepository instance = null;



    private FacilityRepository() {}

    public static FacilityRepository getInstance() {
        if(instance == null) {
            instance = new FacilityRepository();
            return instance;
        }
        return instance;
    }

    boolean addFacility(Facility facility){
        return false;
    }


    public City getCityByZipCode(int zipcode){
        if(cities.containsKey(zipcode)){
            return cities.get(zipcode);
        }else{
            throw new FacilityManagementException("City not found.");
        }
    }

    public List<Facility> getFacilitiesByZipCode(int i) {


        return null;
    }

    public City createCityIfNotExists(int zipcode, String name) {
        if(!this.cities.containsKey(zipcode)){
            cities.put(zipcode, new City(zipcode, name));
            return cities.get(zipcode);
        }else{
            return this.cities.get(zipcode);
        }
    }

    public int readFromFile(String strpath, FacilityFactory factory) {
        int countErr = 0;
        try{
            Path path = Paths.get(strpath);
            List<String> linkedList = Files.readAllLines(path);
            for (String iterator : linkedList) {
                try{
                    facilities.add(factory.createFromString(iterator));
                }catch (Exception err){
                    countErr++;
                    throw new FacilityManagementException(err);
                }
            }
        }catch (Exception err){
            countErr++;
            throw new FacilityManagementException(err);
        }
        return countErr;
    }
}
