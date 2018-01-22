package linkedlist;

public class Test {
    public static void main(String[] args) {
        SListNode l1 = new SListNode(7, new SListNode(0, new SListNode(6)));
        SListNode l2 = new SListNode(2);
        l2.insertAfter(3);
    }
}
