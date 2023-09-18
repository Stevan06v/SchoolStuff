public class List {
    private Item start;


    public void addItem(int value){
        Item newItem = new Item(value);
        // start null = einfügen
        if(start == null){
            start = newItem;
            return;
        }

        Item pointer = start;
        while(pointer.hasNext()){
            pointer = pointer.getNext();
        }

        pointer.setNext(newItem);
    }

    public void printList(){
        Item pointer = start;

        while (pointer != null){
            System.out.println(pointer.value);
            pointer = pointer.getNext();
        }
    }

    public void insertIdx(int idx, int item){
        Item newItem = new Item(item);
        Item pointer = start;
        int c=0;
        while (c < idx){
            pointer = pointer.getNext();
            c++;
        }
        pointer.setNext(newItem);

    }
/*
    public void remItem(Item value){
        if(start.equals(value)){
            start = value;
        }
        Item pointer= new Item();
        while(pointer.hasNext() && pointer.getNext().equals(value)) {
            pointer = pointer.getNext();
        }
    }
    */


    public Item getStart() {
        return start;
    }

    public void setStart(Item start) {
        this.start = start;
    }
}
