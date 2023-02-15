package Main;

public class Node {
    Node right;
    Node left;
    double elem;
    public Node(double elem){
        this.elem= elem;
        left = null;
        right = null;
    }


    public void addItem(double item){
        if(item > this.elem){
            if(this.right != null){
                right.addItem(item);
            }
            Node newNode = new Node(item);
            right = newNode;
        }else{
            if(this.left != null){
                    left.addItem(item);
            }
            Node newNode = new Node(item);
            left = newNode;
        }




    }
}
