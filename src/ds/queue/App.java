package ds.queue;

public class App {

    public static void main(String[] args) {
        Queue myQueue = new Queue(3);
        myQueue.insert(1);
        myQueue.view();
        System.out.println();
        myQueue.insert(2);
        myQueue.view();
        System.out.println();
        myQueue.insert(3);
        myQueue.view();
        System.out.println();
        myQueue.insert(4);
        myQueue.view();
        System.out.println();
        myQueue.insert(5);
        myQueue.view();
        System.out.println();
        myQueue.insert(6);
        myQueue.view();
        System.out.println();
    }
}
