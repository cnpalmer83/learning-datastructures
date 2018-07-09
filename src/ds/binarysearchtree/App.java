package ds.binarysearchtree;

import java.util.Random;

/*
    This program implements the given BST by creating a BST object and then
    populating it with 8 random integers between 0-99.  Order of entry is displayed
    prior to the tree to examine how each node is placed.
 */
public class App {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        Random rand = new Random();

        System.out.print("Order of entry: " + "{ ");
        for (int i = 0; i < 8; i++) {
            int rand_int = rand.nextInt(100);
            tree.insert(rand_int, "Random value");
            System.out.print(rand_int + " ");
        }
        System.out.println("}");
        System.out.println(tree.findMaximum().key);
        System.out.println(tree.findMinimum().key);
        tree.displayTree();
    }
}
