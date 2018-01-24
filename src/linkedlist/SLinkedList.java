package linkedlist;

/**
 * Private methods or fields. Why?
 * - to prevent data from being corrupted by other classess
 * - you can improve the implementation without causing other classes to fail
 * <p>
 * What is interface of a class?
 * Prototypes for public methods, plus descriptions of their behaviors
 * <p>
 * What is Abstract Data Type (ADT)?
 * a class with a well-defined interface, but implementation details are hidden from classes
 * <p>
 * What is Invariant?
 * a fact about a data structure that is always true
 * for.ex: "A Date object always represents a valid date"
 */

/**
 * SList Invariants:
 * - "size" is always correct
 * - list is never circularly linked
 */
public class SLinkedList {
    private SListNode head;
    private int size;

    public SLinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean empty() {
        return this.size == 0;
    }

    public Object valueAt(int index) {
        if (index >= 0 && index < size) {
            return this.nodeAt(index).item;
        }
        return null;
    }

    public void pushFront(Object item) {
        this.head = new SListNode(item, this.head);
        this.size++;
    }

    public Object popFront() {
        if (this.size > 0) {
            Object item = this.head.item;
            this.head = this.head.next;
            this.size--;
            return item;
        }
        return null;
    }

    public void pushBack(Object item) {
        SListNode tail = this.head;
        for (int i = 1; i < this.size; i++) {
            tail = tail.next;
        }
        if (tail == null) {
            this.head = new SListNode(item, null);
        } else {
            tail.next = new SListNode(item, null);
        }
        this.size++;
    }

    public Object popBack() {
        Object item = null;
        if (this.size == 1) {
            item = this.head.item;
            this.head = null;
            this.size--;
        } else if (this.size > 1) {
            SListNode preTail = this.head;
            for (int i = 1; i < this.size - 1; i++) {
                preTail = preTail.next;
            }
            item = preTail.item;
            preTail.next = null;
            this.size--;
        }
        return item;
    }

    public Object front() {
        return this.head == null ? null : this.head.item;
    }

    public Object back() {
        SListNode tail = this.head;
        for (int i = 1; i < this.size; i++) {
            tail = tail.next;
        }
        return tail == null ? null : tail.item;
    }

    public void insert(int index, Object item) {
        if(index >= 0 && index <= this.size) {
            SListNode node = this.head;
            for (int i = 1; i < index; i++) {
                node = node.next;
            }
            node.next = new SListNode(item, node.next);
            this.size++;
        }
        throw new IndexOutOfBoundsException();
    }

    public void erase(int index) {
        if (index >= 0 && index < this.size) {
            SListNode node = this.head;
            for (int i = 1; i < index; i++) {
                node = node.next;
            }
            if(node == this.head) {
                this.head = this.head.next;
            } else {
                node.next = node.next.next;
            }
            this.size--;
        }
        throw new IndexOutOfBoundsException();
    }

    public Object valueNFromEnd(int n) {
        if(n <= this.size) {
            return this.valueAt(this.size - n);
        }
        throw new IndexOutOfBoundsException();
    }

    public void reverse() {
        SListNode tail = this.nodeAt(this.size - 1);
        reverse(this.head);
        this.head = tail;
    }

    private SListNode nodeAt(int index) {
        SListNode value = this.head;
        for (int i = 1; i <= index; i++) {
            value = value.next;
        }
        return value;
    }

    private void reverse(SListNode node) {
        if(node.next != null) {
            this.reverse(node.next);
        }
        node.next = node;
    }

    public void removeValue(Object value) {
        SListNode node = this.head;
        for (int i = 1; i < this.size; i++) {
            if(node.item == value) {
                this.erase(i - 1);
                break;
            }
        }
    }
}
