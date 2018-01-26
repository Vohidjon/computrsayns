package linkedlist;

public class Test {
    public static void main(String[] args) {
        SLinkedList linkedList = new SLinkedList();
        linkedList.pushFront(12);
        linkedList.pushFront(13);
        assert linkedList.size() == 2 : "Size must be 2 at this point";

        linkedList.popFront();
        linkedList.popFront();
        assert linkedList.empty() : "List must be empty";

        linkedList.pushFront(3);
        linkedList.pushFront(5);
        assert (int)linkedList.valueAt(1) == 5 : "The value at index 1 must be 5";

        linkedList.pushFront(7);
        assert (int) linkedList.front() == 7 : "The first item must be 7";

        int oldSize = linkedList.size();
        linkedList.popFront();
        assert oldSize - 1 == linkedList.size() : "The size must decrease by 1";

        linkedList.pushBack(16);
        assert (int)linkedList.back() == 5 : "The last item must be 16";

        linkedList = new SLinkedList();
        linkedList.pushFront(7);
        linkedList.pushFront(8);
        linkedList.pushFront(10);
        linkedList.insert(2, 9);
        assert (int)linkedList.valueAt(2) == 9 : "The value must be inserted at 2 index";

        linkedList.erase(1);
        assert (int)linkedList.valueAt(1) != 8 : "THe old value (8) should not be there";

        linkedList = new SLinkedList();
        linkedList.pushFront(4);
        linkedList.pushFront(3);
        linkedList.pushFront(2);
        linkedList.pushFront(1);
        assert (int)linkedList.valueNFromEnd(3) == 3 : "The value must be 3";

        linkedList.reverse();
        assert (int) linkedList.valueAt(0) == 1 && (int) linkedList.valueAt(1) == 2
                && (int) linkedList.valueAt(2) == 3 && (int) linkedList.valueAt(3) == 4 : "The list must be reversed";

        linkedList = new SLinkedList();
        linkedList.pushFront(13);
        linkedList.pushFront(14);
        linkedList.pushFront(15);
        linkedList.removeValue(14);
        assert (int) linkedList.valueAt(1) != 14 : "The value must no longer be at index 1";
    }
}
