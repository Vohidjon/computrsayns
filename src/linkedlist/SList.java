package linkedlist;

public class SList {
    private SListNode head;
    private int size;

    public SList() {
        head = null;
        size = 0;
    }

    public void insertFront(Object item) {
        this.head = new SListNode(item, this.head);
        this.size++;
    }
}
