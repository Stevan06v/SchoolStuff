
/**
 *
 * @author steva
 */
public class LinkedList {

    protected ListItem start;

    public LinkedList() {
        start = null;
    }

    public void add(int value) {

        ListItem newItem = new ListItem(value);
        
        if (start == null) {
            //start zeigt auf newItem
            this.start = newItem;
            return;
        }
        
        //an letztes item anhängen
        start.next = newItem;
    }

    public void get(int pos) {
    }

    public void remove(int value) {
    }

}
