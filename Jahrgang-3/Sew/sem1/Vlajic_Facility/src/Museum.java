import java.util.ArrayList;import java.util.LinkedHashMap;import java.util.LinkedHashSet;import java.util.List;public class Museum extends Facility{    LinkedHashSet<String> collectionFoci = new LinkedHashSet<>();   // "Lentos Kunstmuseum Linz", linz, "Ernst-Koref-Promenade", 1    public Museum( String name,City city, String street, int houseNumber) {        super(city, name, street, houseNumber);    }    public LinkedHashSet<String> getCollectionFoci() {        return collectionFoci;    }    public void setCollectionFoci(LinkedHashSet<String> collectionFoci) {        this.collectionFoci = collectionFoci;    }    public boolean addCollectionFocus(String naturwissenschaft) {        if(!this.hasCollectionFocus(naturwissenschaft)){            collectionFoci.add(naturwissenschaft);            return true;        }else{            return false;        }    }    ///Biologiezentrum Linz (J.-W.-Klein-Straße 73, 4040 Linz) - Sammlungsschwerpunkte: Naturwissenschaft    @Override    public String toString() {        String[] focis = new String[this.collectionFoci.size()];        List<String> list = new ArrayList<>(this.collectionFoci);        for (int i = 0; i < list.size(); i++) {            focis[i] = list.get(i);        }        return String.format("%s (%s %s, %s) - Sammlungsschwerpunkte: %s",super.getName(), super.getStreet(), super.getHouseNumber(), super.getCity().toString(), String.join(", ", focis));    }    public boolean hasCollectionFocus(String natur) {        if(this.collectionFoci.contains(natur)){            return true;        }else{            return false;        }    }}