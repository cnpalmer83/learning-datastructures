package ds.binarysearchtree;

import java.util.Random;

/*
    This program implements the given BST by creating a BST object and then
    populating it with 8 integers from an unsorted array.  Order of entry is displayed
    prior to the tree to examine how each node is placed.
 */
public class App {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        int [] testArray = {63,71,59,26,59,12,90,89};
        System.out.println("Order of entry: {63 71 59 26 59 12 90 89} ");

        for (int i = 0; i < testArray.length; i++) {
            tree.insert(testArray[i], "Random value");
        }

        System.out.println("Maximum value: " + tree.findMaximum().key);
        System.out.println("Minimum value: " + tree.findMinimum().key);

        tree.displayTree();
        tree.displayInOrder(tree.root);
        System.out.println("\nNumber of nodes: " + tree.getNodeCount());

        System.out.println("Maximum value: " + tree.findMaximum().key);
        System.out.println("Largest node deleted...");

        tree.displayTree();
        tree.displayInOrder(tree.root);
        System.out.println("\nNumber of nodes: " + tree.getNodeCount());

        tree.remove(tree.root.key);
        System.out.println("Root node deleted...");

        tree.displayTree();
        tree.displayInOrder(tree.root);
        System.out.println("\nNumber of nodes: " + tree.getNodeCount());
    }
}
