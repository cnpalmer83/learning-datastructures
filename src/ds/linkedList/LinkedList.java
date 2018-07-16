package ds.linkedList;

public class LinkedList {

    private Node first;
    private Node last;

    public boolean isEmpty() {
        return (first == null);
    }

    // Insert at beginning of the list
    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;
        first = newNode;

        if (first.next == null) {
            last = first;
        }
    }

    public void insertLast(int data) {
        if (isEmpty())
            insertFirst(data);
        else {
            Node newNode = new Node();
            newNode.data = data;
            last.next = newNode;
            last = newNode;
        }
    }

    public Node deleteFirst() {
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("List (First --> Last) ");
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }
}
