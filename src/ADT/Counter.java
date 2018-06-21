package ADT;

public class Counter {
    private String name;
    private int count;

    public Counter(String str) {
        this.name = str;
        this.count = 0;
    }

    public void increment() {
        this.count++;
    }

    public int getCurrentValue() {
        return this.count;
    }

    public String toString() {
        return name + ": " + count;
    }
}
