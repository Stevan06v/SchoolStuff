import java.util.Objects;

public class City implements Comparable<City>{

    private String name;
    private int zipCode;

    public City(int zipCode,String name) {
        this.name = name;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d %s", this.zipCode, this.name);
    }

    public int getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        return ((City) o).zipCode == this.zipCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getZipCode());
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int compareTo(City linz) {
        return Integer.compare(this.zipCode, linz.getZipCode());
    }

}
