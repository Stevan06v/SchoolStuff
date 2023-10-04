import java.io.OptionalDataException;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

public class Cart {
    private static NumberFormat cf;
    public List<Position>content = new LinkedList();
    private static NumberFormat nf;

    public Cart() {}

    public void addContent(Object buyable){
        this.content.add((Position) buyable);
    }
    public double getValue(){
        return 0.0;
    }

}
