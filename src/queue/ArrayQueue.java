package queue;

public class ArrayQueue {
    private Object[] array;
    private int read = 0;
    private int write = 0;

    public ArrayQueue() {
        this(16);
    }

    public ArrayQueue(int queueSize) {
        this.array = new Object[queueSize + 1];
    }

    public void enqueue(Object value) {
        if(this.isFull()) throw new Error("Queue is full");
        this.array[this.write] = value;
        this.write = (this.write + 1) % this.array.length;
    }

    public Object dequeue() {
        if(this.isEmpty()) return null;
        Object value = this.array[this.read];
        this.read = (this.read + 1) % this.array.length;
        return value;
    }

    public boolean isEmpty() {
        return this.read == this.write;
    }

    public boolean isFull(){
        return (this.array.length - (this.write - this.read + 1)) % this.array.length == 0;
    }
}
