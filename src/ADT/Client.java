package ADT;

public class Client {
    public static void main(String[] args) {

        Counter myCounter = new Counter("Shit");

        System.out.println(myCounter.toString());

        myCounter.increment();
        myCounter.increment();

        System.out.println(myCounter.toString());
    }
}
