package ds.binarysearchtree;

public class App {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10, "Ten");
        tree.insert(20, "Twenty");
        tree.insert(15, "Fifteen");


        System.out.println(tree.findMaximum().key);
        System.out.print(tree.findMinimum().key);
    }
}
