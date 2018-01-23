package linkedlist;

/**
 * Private methods or fields. Why?
 * - to prevent data from being corrupted by other classess
 * - you can improve the implementation without causing other classes to fail
 *
 * What is interface of a class?
 * Prototypes for public methods, plus descriptions of their behaviors
 *
 * What is Abstract Data Type (ADT)?
 * a class with a well-defined interface, but implementation details are hidden from classes
 *
 * What is Invariant?
 * a fact about a data structure that is always true
 *  for.ex: "A Date object always represents a valid date"
 */

/**
 * SList Invariants:
 * - "size" is always correct
 * - list is never circularly linked
 */
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
