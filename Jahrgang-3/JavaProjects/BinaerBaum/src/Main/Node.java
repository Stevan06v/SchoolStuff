package Main;

public class Node {
    int value;
    Node left;
    Node rigth;

    public Node(int item) {
        this.value = item;
    }

        public void addNode(int value){
            if(this.value > value){
                if(this.rigth != null){
                    this.rigth.addNode(value);
                }
                Node newItem = new Node(value);
                this.rigth = newItem;
            }else {
                if (this.left != null) {
                    this.left.addNode(value);
                }
                Node newItem = new Node(value);
                this.left = newItem;
            }
    }


    public void printNode(){
        if(this.left != null){
            left.printNode();
        }
        System.out.println(this.left);

        if(this.rigth != null){
            rigth.printNode();
        }
        System.out.println(this.rigth);
    }

}
