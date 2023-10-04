package Main;

public class BinaryTree {
    Node root;

    public void add(int value){
        Node newItem = new Node(value);
        if(root == null){
            root = newItem;
            return;
        }
        if(root.value > value){
            root.rigth = newItem;
        }else{
            root.left= newItem;
        }
    }
    public void printTree(){
        if (this.root != null){
            root.printNode();
        }
    }

    public void remove(){}

}
