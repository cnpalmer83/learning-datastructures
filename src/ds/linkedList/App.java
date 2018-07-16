package ds.linkedList;

public class App {

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.insertFirst(100);
        myList.insertFirst(50);
        myList.insertFirst(99);
        myList.insertFirst(88);
        myList.insertLast(35);
        myList.displayList();
        myList.deleteFirst();
        System.out.println("Deleting first node... deleted.");
        myList.displayList();
    }
}
