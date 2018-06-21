package ds.circularLinkedList;

public class CircularLinkedList {

    private Node first;
    private Node last;

    public CircularLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;       //newNode assigned to old first
        first = newNode;            //newNode is now in the first place
    }

    public void insertLast(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()) {
            first = newNode;
        }
        else {
            last.next = newNode;    // next value of last node points to newNode
            last = newNode;         // newNode designated as the new last node in list
        }
    }

    public int deleteFirst() {
        int temp = first.data;

        if (first.next == null) {
            last = null;
        }
        first = first.next;         // first will point to old's next value
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
