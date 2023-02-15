public abstract class Facility implements Comparable<Facility> {

    private City city;
    private String name;
    private String street;
    private int houseNumber;

    public Facility(String name,City city, String street, int houseNumber) {
        this.city = city;
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public int compareTo(Facility o) {
        return Integer.compare(this.city.getZipCode(), o.city.getZipCode());
    }

    public boolean hasCollectionFocus(String zeitgeschichte) {
        return true;
    }

    public boolean addCollectionFocus(String naturwissenschaft) {
        return false;
    }
}
