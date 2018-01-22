package linkedlist;

/**
 * Advantages over array lists:
 * - inserting item int middle of linked list takes constant time given the list is doubly-linked
 * - moreover, lists can keep growing
 * Disadvantages:
 * - finding the nth item of a linked list takes time proportional to length of list
 * Disadvantages with SListNode:
 * - inserting item in the beginning of list
 * - now way to represent an empty list
 */
public class SListNode {
    public Object item;
    public SListNode next;

    public SListNode(Object item){
        this(item, null);
    }

    public SListNode(Object item, SListNode next) {
        this.item = item;
        this.next = next;
    }

    public void insertAfter(int item) {
        this.next = new SListNode(item, this.next);
    }

    public SListNode nth(int position) {
        if(position == 1) {
            return this;
        } else if((position < 1) || (this.next == null)) {
            return null;
        } else {
            return this.next.nth(position - 1);
        }
    }
}