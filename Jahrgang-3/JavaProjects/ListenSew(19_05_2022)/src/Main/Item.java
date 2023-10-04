package Main;

public class Item<T>{
    Item <T> next;
    Item <T> value;

    public Item(Item value){
        this.value = value;
    }

    public Item(Object o) {
    }

    public boolean hasNext(){
        if(this.next == null){
            return false;
        }else{
            return true;
        }
    }
}
