package ds.queue;

public class Queue {

    private int maxSize;
    private long[] queArray;
    private int front;          // index position for front element
    private int rear;           // index position for rear element
    private int nItems;         // counter for # of items in the queue

    public Queue(int size) {
        this.maxSize = size;
        this.queArray = new long[size];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(long j) {

        if (rear == maxSize - 1) {  // If queue is full, return to beginning
            rear = -1;              // Circular queue (optional)
        }

        rear++;
        queArray[rear] = j;
        nItems++;
    }

    public long remove() {

        long temp = queArray[front];
        front++;

        if (front == maxSize) {     // If queue full, return to beginning
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peakFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }


    public void view() {
        System.out.print("[ ");
        for(int i = 0; i < queArray.length; i++) {
            System.out.print(queArray[i] + " ");
        }
        System.out.print("]");
    }
}
