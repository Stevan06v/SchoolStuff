import java.net.Inet4Address;

public class SchoolFactory {

    private static Facility creatFromString(){
        return null;
    }

    public Facility createFromString(String string) {

        FacilityRepository repo = FacilityRepository.getInstance();

        School school = null;
        String[] attributes = string.split(";");

        for (String iterator : attributes) {
            iterator.strip();
        }

        try{
            int school_id = Integer.parseInt(attributes[0]);
            String school_type = attributes[1];
            String street = attributes[3];
            String name  = attributes[2];

            int house_number = Integer.parseInt(attributes[4]);

            int zip_code = Integer.parseInt(attributes[5]);

            school = new School(name, repo.createCityIfNotExists(zip_code, name), street, house_number, school_type);

        }catch (Exception err){
            throw new FacilityManagementException(err);
        }
        return school;
    }
}
