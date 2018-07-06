package ds.binarysearchtree;

public class BinarySearchTree {

    private Node root;

    public void insert(int key, String value) {

        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        }
        else {
            Node current = root;        // A node for traversing tree
            Node parent;

            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null) {  // It's parent is the leaf node
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findMinimum() {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node findMaximum() {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean remove(int key) {

        // Scenario 1: Is the node a leaf?

        // Scenario 2: Does the node have one child?

        // Scenario 3: Does the node have two children?

        return true;
    }


}
