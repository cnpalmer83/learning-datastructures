package ds.doublyLinkedList;

public class App {

    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(1);
        theList.insertFirst(2);
        theList.insertFirst(3);

        theList.insertLast(4);
        theList.insertLast(5);
        theList.insertLast(6);

        theList.displayForward();
        theList.displayBackward();

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(1);

        theList.displayForward();

        theList.insertAfter(2, 77);
        theList.insertAfter(4, 88);

        theList.displayForward();
    }
}
