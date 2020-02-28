package toptal;

public class LinkedLists {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        assert list.size() == 0;
        list.pushBack(13);
        list.pushFront(12);
        assert list.front() == 12;
        assert list.back() == 13;
        assert list.size() == 2;
        assert !list.empty();
        assert list.valueAt(1) == 13;
        assert list.popBack() == 13;
        assert list.size() == 1;
        boolean threw = false;
        try {
            list.insert(2, 14);
        } catch (IndexOutOfBoundsException e) {
            threw = true;
        }
        assert threw;
        list.insert(1, 14);
        assert list.valueAt(1) == 14;
        list.pushFront(11);
        assert list.valueAt(0) == 11;
        assert list.popFront() == 11;
        list = new LinkedList();
        list.reverse();
        list.removeValue(12);
        threw = false;
        try {
            list.erase(0);
        } catch (IndexOutOfBoundsException e) {
            threw = true;
        }
        assert threw;
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.reverse();
        assert list.front() == 1;
        assert list.valueAt(1) == 2;
        assert list.back() == 3;
    }
}

class LinkedList {
    private long size = 0;
    private ListNode dummy;

    public LinkedList() {
        dummy = new ListNode(-1);
    }

    public long size() {return size;}

    public boolean empty() {
        return dummy.next == null;
    }

    public int valueAt(int index) {
        ListNode node = dummy;
        while (index >= 0) {
            node = node.next;
            index--;
        }

        if(node == null) throw new IndexOutOfBoundsException();

        return node.val;
    }

    public void pushFront(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = dummy.next;
        dummy.next = newNode;
        size++;
    }

    public int popFront() {
        if(size == 0) throw new IndexOutOfBoundsException();

        int val = dummy.next.val;
        dummy.next = dummy.next.next;
        size--;
        return val;
    }

    public void pushBack(int val) {
        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(val);
        size++;
    }

    public int popBack() {
        if(size == 0) throw new IndexOutOfBoundsException();

        ListNode node = dummy;
        while (node.next.next != null) {
            node = node.next;
        }

        int val = node.next.val;
        node.next = null;
        size--;
        return val;
    }

    public int front() {
        if(size == 0) throw new IndexOutOfBoundsException();
        return dummy.next.val;
    }

    public int back() {
        if(size == 0) throw new IndexOutOfBoundsException();

        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }

        return node.val;
    }

    public void insert(int index, int val) {
        ListNode node = dummy;
        for(int i = 0; i < index; i++) {
            if(node.next == null) throw new IndexOutOfBoundsException();
            node = node.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    public void erase(int index) {
        ListNode node = dummy;
        for (int i = 0; i < index; i++) {
            if(node.next == null) throw new IndexOutOfBoundsException();

            node = node.next;
        }

        if(node.next == null) throw new IndexOutOfBoundsException();

        node.next = node.next.next;
        size--;
    }

    public void reverse() {
        ListNode node = dummy.next;
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        dummy.next = prev;
    }

    public void removeValue(int val) {
        ListNode node = dummy;
        while (node.next != null && node.next.val != val) {
            node = node.next;
        }

        if(node.next != null) {
            node.next = node.next.next;
            size--;
        }
    }

    class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}