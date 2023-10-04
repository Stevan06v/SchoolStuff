import java.util.Objects;

public class School extends Facility{

    private SchoolType schoolType;

    public School(String name, City city,  String street, int houseNumber, SchoolType schoolType) {
        super(name, city,  street, houseNumber);
        this.schoolType = schoolType;
    }



    public School(String name, City city, String street, int houseNumber, String schoolType) {
        super(name, city,  street, houseNumber);
        this.schoolType = parseSchoolType(schoolType);
    }

    public static SchoolType parseSchoolType(String schoolTypeRaw) {
        if(schoolTypeRaw.contains("Mittelschule")) {
            return SchoolType.MS;
        }
        if(schoolTypeRaw.contains("Volksschule")) {
            return SchoolType.VS;
        }
        if(schoolTypeRaw.contains("Kaufmännische")) {
            return SchoolType.HAK;
        }
        if(schoolTypeRaw.contains("Technische")) {
            return SchoolType.HTL;
        }
        if(schoolTypeRaw.contains("AHS")) {
            return SchoolType.AHS;
        }
        if(schoolTypeRaw.contains("Kolleg")) {
            return SchoolType.KOLLEG;
        }
        return SchoolType.SONSTIGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;
        if(((School) o).schoolType.equals(((School) o).schoolType) && ((School) o).getStreet().equals(this.getStreet())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchoolType());
    }

    public SchoolType getSchoolType() {
        return schoolType;
    }
}
