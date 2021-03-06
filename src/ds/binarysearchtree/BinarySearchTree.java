package ds.binarysearchtree;


import java.util.Stack;

public class BinarySearchTree {

    protected Node root;
    private int nodeCount = 0;

    public void insert(int key, String value) {

        Node newNode = new Node(key, value);
        nodeCount++;
        if (root == null)
            root = newNode;
        else {
            Node current = root;        // A node for traversing tree
            Node parent;

            while (true) {
                parent = current;
                if (key <= current.key) {
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

    public int getNodeCount() {
        return nodeCount;
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

        // Placeholders to traverse tree
        Node currentNode = root;
        Node parentNode = root;     // parent to whatever currentNode is
        boolean isLeftChild = false;    // Determines if deleted node is left or right child

        // First, we have to find the node that is to be deleted:
        while (currentNode.key != key) {
                parentNode = currentNode;
            if (key > currentNode.key) {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
            else {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            }
            if (currentNode == null)
                return false;           // if key not found in tree
        }

        // Now the node to delete has been found.  We have to account for three
        // possible scenarios for the node.  It might be a leaf, it might have
        // one child, or it might have two children.  For readability, currentNode
        // will be renamed to nodeToDelete (this is optional)
        Node nodeToDelete = currentNode;

        // Scenario 1: Is the node a leaf?
        // Assign parent node reference to null, Java takes care of the rest
        if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
            if (nodeToDelete == root)
                root = null;
            else if (isLeftChild)
                parentNode.leftChild = null;
            else
                parentNode.rightChild = null;
        }

        // Scenario 2: Does the node have one child?
        // Copy subtree into deleted node position

        // Node to delete has one child to the left and rightChild is null
        else if (nodeToDelete.rightChild == null) {
            if (nodeToDelete == root)
                root = nodeToDelete.leftChild;
            else if (isLeftChild)
                parentNode.leftChild = nodeToDelete.leftChild;
            else
                parentNode.rightChild = nodeToDelete.leftChild;
        }

        // Node to delete has one child to the right and leftChild is null
        else if (nodeToDelete.leftChild == null) {
            if (nodeToDelete == root)
                root = nodeToDelete.rightChild;
            else if (isLeftChild)
                parentNode.leftChild = nodeToDelete.rightChild;
            else
                parentNode.rightChild = nodeToDelete.rightChild;
        }

        // Scenario 3: Does the node have two children?
        // Replace deleted node with smallest node from subtree (in order successor)
        else {
            // Step 1: find the successor to replace deleted node
            Node successor = getSuccessor(nodeToDelete);

            // Step 2: connect deleted node's parent to successor
            if (nodeToDelete == root)
                root = successor;
            else if (isLeftChild)
                parentNode.leftChild = successor;
            else
                parentNode.rightChild = successor;

            successor.leftChild = nodeToDelete.leftChild;

        }
        nodeCount--;
        return true;
    }

    private Node getSuccessor(Node nodeToDelete) {

        Node successorParent = nodeToDelete;
        Node successor = nodeToDelete;

        // Get right child first
        Node current = nodeToDelete.rightChild;

        // Then find smallest of the right child
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        // The smallest value in the subtree has been found (the in order successor)

        // If successor is not a right child
        if ( successor != nodeToDelete.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = nodeToDelete.rightChild;
        }
        return successor;
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(".............................................................");

        while(isRowEmpty==false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(" ");
            }

            while(globalStack.isEmpty()==false) {
                Node temp = (Node)globalStack.pop();
                if(temp != null) {
                    System.out.print(temp.key);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("><");
                    localStack.push(null);
                    localStack.push(null);
                }

                for(int j=0; j<nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();
            nBlanks = nBlanks/2;

            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }
        System.out.println( "............................................................");

    }

    public void displayInOrder(Node root) {
        if (root == null)
            return;
        else {
            displayInOrder(root.leftChild);
            System.out.print(root.key + " ");
            displayInOrder(root.rightChild);
        }
    }

    public void emptyTree() {
        while (!isEmpty()) {
            remove(this.root.key);
        }
    }

    public boolean isEmpty() {
        if (this.root == null)
            return true;
        else
            return false;
    }

    // creates sorted array of tree keys for balanceTree method
    // (this is really bad...)
    private int [] keyArray() {
        int [] temp = new int[nodeCount];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = findMinimum().key;
            remove(findMinimum().key);
        }
        return temp;
    }

    public void balanceTree() {
        int [] temp = keyArray();
        int middle = ((0 + (temp.length - 1)) / 2);
        int insertKey = middle - 2;

        insert(temp[middle], "root inserted");

        // Insert left nodes
        while (insertKey >= 0) {
            insert(temp[insertKey], "left node sorted");
            insertKey = insertKey - 2;
        }
        insertKey = middle - 1;

        while (insertKey >= 0) {
            insert(temp[insertKey], "left node sorted");
            insertKey = insertKey - 2;
        }
        insertKey = middle + 2;

        // Insert right nodes
        while (insertKey < temp.length) {
            insert(temp[insertKey], "right node sorted");
            insertKey = insertKey + 2;
        }
        insertKey = middle + 1;

        while (insertKey < temp.length) {
            insert(temp[insertKey], "right node sorted");
            insertKey = insertKey + 2;
        }
    }
}
