public class Item {
    private Item next;
    private Item prev;
    public int value;

    public Item(int val){
        this.value = val;
    }

    public boolean hasNext(){
        if(this.next == null){
            return false;
        }else{
            return true;
        }
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }

    public Item getPrev() {
        return prev;
    }

    public void setPrev(Item prev) {
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
