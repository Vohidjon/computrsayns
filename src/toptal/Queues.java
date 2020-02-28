package toptal;

public class Queues {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(4);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assert q.isFull();
        assert q.dequeue() == 1;
        assert q.dequeue() == 2;
        assert q.dequeue() == 3;
        assert q.isEmpty();
    }
}

class ArrayQueue {
    private int[] arr;
    private int read;
    private int write;

    public ArrayQueue(int size) {
        arr = new int[size];
        read = 0;
        write = 0;
    }

    public void enqueue(int v) {
        if((write + 1) % arr.length == read) throw new IllegalStateException("Your queue is full");
        arr[write++] = v;
    }

    public int dequeue() {
        if(read == write) throw new IllegalStateException("No items in the queue");
        return arr[read++];
    }

    public boolean isEmpty() {
        return read == write;
    }

    public boolean isFull() {
        return (write + 1) % arr.length == read;
    }
}

class LinkedQueue {
    private Node head;
    private Node tail;
    public LinkedQueue() {
    }

    public void enqueue(int v) {
        Node node = new Node(v);
        if(head == null) {
            head = tail = node;
        } else {
            tail = tail.next = node;
        }
    }

    public int dequeue() {
        if(head == null) throw new IllegalStateException("No items in the list");
        int val = head.val;
        head = head.next;
        if(head == null) tail = null;

        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

class Node {
    public int val;
    public Node next;
    public Node (int v) {
        val = v;
    }
}