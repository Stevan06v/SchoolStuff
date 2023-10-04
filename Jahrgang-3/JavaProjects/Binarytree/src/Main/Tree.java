package Main;

public class Tree {
    Node root;

    public void addNode(double item){
        if(root == null) {
            root = new Node(item);
        }
        root.addItem(item);
    }
}
