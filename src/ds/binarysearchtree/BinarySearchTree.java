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
}
