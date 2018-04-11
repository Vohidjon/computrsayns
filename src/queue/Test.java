package queue;

public class Test {
    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        assert linkedQueue.isEmpty() : "Must initially be empty";
        linkedQueue.enqueue(12);
        linkedQueue.enqueue(13);
        linkedQueue.enqueue(14);
        assert (int)linkedQueue.dequeue() == 12 : "Must be 12 - the first enqueued item";
        linkedQueue.dequeue();
        linkedQueue.dequeue();
        assert linkedQueue.isEmpty() : "Must be empty at this point";

        ArrayQueue arrayQueue = new ArrayQueue(4);
        assert arrayQueue.isEmpty() : "Must initially be empty";
        arrayQueue.enqueue(13);
        arrayQueue.enqueue(14);
        arrayQueue.enqueue(15);
        arrayQueue.enqueue(16);

        boolean isErrorThrown = false;
        try {
            arrayQueue.enqueue(17);
        } catch (Error e) {
            isErrorThrown = true;
        }

        assert isErrorThrown : "Must throw error";

        assert (int) arrayQueue.dequeue() == 13 : "Should get first enqueued number";

    }
}
