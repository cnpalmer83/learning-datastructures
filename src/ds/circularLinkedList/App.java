package ds.circularLinkedList;

/*
    Circular Linked List is almost identical to a standard Linked List with the
    added 'last' variable.  'Last' allows access to the end of the list
    without having to traverse each node.
 */

public class App {

    public static void main(String[] args) {
        CircularLinkedList myList = new CircularLinkedList();
        myList.insertFirst(100);
        myList.insertFirst(50);
        myList.insertFirst(99);
        myList.insertFirst(88);
        myList.insertLast(35);

        myList.displayList();
    }
}
