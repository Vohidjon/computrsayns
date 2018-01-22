package linkedlist;

class ListNode {
    public int item;
    public ListNode next;

    public ListNode(int item, ListNode next) {
        this.item = item;
        this.next = next;
    }

    public void insertAfter(int item) {
        next = new ListNode(item, next);
    }

    public ListNode nth(int position) {
        if(position == 1) {
            return this;
        } else if((position < 1) || (this.next == null)) {
            return null;
        } else {
            return this.next.nth(position - 1);
        }
    }
}

class RunIt{
    public static void main(String[] args) {

    }
}