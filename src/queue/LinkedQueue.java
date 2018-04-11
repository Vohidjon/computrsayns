package queue;

public class LinkedQueue {
    private QueueNode head;
    private QueueNode tail;

    public void enqueue(Object value) {
        QueueNode newItem = new QueueNode(value);
        if(this.isEmpty()) {
            this.head = this.tail = newItem;
            return;
        }
        this.tail = this.tail.next = newItem;
    }

    public Object dequeue() {
        if(this.isEmpty()) {
            return null;
        }
        Object headValue = this.head.value;
        this.head = this.head.next;
        if(this.isEmpty()) {
            this.head = this.tail = null;
        }
        return  headValue;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}

class QueueNode {
    public Object value;
    public QueueNode next;

    public QueueNode(Object value){
        this(value, null);
    }

    public QueueNode(Object value, QueueNode next) {
        this.value = value;
        this.next = next;
    }
}