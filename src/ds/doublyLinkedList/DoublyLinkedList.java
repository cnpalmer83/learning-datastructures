package ds.doublyLinkedList;

public class DoublyLinkedList {

    private Node first;
    private Node last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()) {
            last = newNode;     // last refers to newNode if empty
        }
        else {
            first.previous = newNode;
        }
        newNode.next = first;   // newNode.next points to previous first node
        this.first = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()) {
            first = newNode;
        }
        else {
            this.last.next = newNode;
            newNode.previous = this.last;
        }
        last = newNode;         // 'last' should point to the new node
    }

    // assume list is not empty *************
    public Node deleteFirst() {
        Node temp = first;
        if(first.next == null) {
            last = null;
        }
        else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public Node deleteLast() {
        Node temp = last;
        if(first.next == null) {     // true if there is only 1 node in list
            first = null;
        }
        else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    // assume list is not empty ************
    public boolean insertAfter(int key, int data) {
        Node current = first;       // start from beginning of list
        while (current.data != key) {
            current = current.next;
            if (current == null)
                return false;
        }
        Node newNode = new Node();
        newNode.data = data;

        if (current == last) {
            current.next = null;
            last = newNode;
        }
        else {
            newNode.next = current.next;
            current.next.previous = newNode;
        }
        newNode.previous = current;
        current.next = newNode;
        return true;
    }

    // assume list is not empty ***************
    public Node deleteKey(int key) {
        Node current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            first = current.next;
        }
        else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = current.previous;
        }
        else {
            current.next.previous = current.previous;
        }

        return current;
    }

    public void displayForward() {
        System.out.println("List (First --> Last): ");
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.println("List (Last --> First): ");
        Node current = last;
        while (current != null) {
            current.displayNode();
            current = current.previous;
        }
        System.out.println();
    }
}
