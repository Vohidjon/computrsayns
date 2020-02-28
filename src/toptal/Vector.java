package toptal;

import java.util.ArrayList;

public class Vector {
    public static void main(String[] args) {
        VectorImpl v = new VectorImpl();
        v.push(13);
        assert v.size() == 1;
        v.delete(0);
        assert v.size() == 0;
        assert v.capacity() == 16;
        v.push(13);
        v.insert(0, 12);
        assert v.atIndex(0) == 12;
        v.pop();
        assert v.size() == 1;
        assert v.find(12) == 0;
        v.remove(12);
        assert v.size() == 0;
        assert v.isEmpty();
        v.push(13);
        v.update(0, 12);
        assert v.atIndex(0) == 12;
    }
}

class VectorImpl {
    private int[] arr;
    private int size = 0;

    public VectorImpl() {
        arr = new int[16];
    }

    public VectorImpl(int capacity) {
        int c = 16;
        while (c < capacity) c *= 2;
        arr = new int[c];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int atIndex(int index) {
        if(index >= 0 && index < size) {
            return arr[index];
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public void push(int item) {
        arr[size] = item;
        size++;
        resize();
    }

    public void insert(int index, int item) {
        if(index >= 0 && index <= size) {
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = item;
            size++;
            resize();
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public void prepend(int item) {
        insert(0, item);
    }

    public void update(int index, int newItem) {
        if(index >= 0 && index < size) {
            arr[index] = newItem;
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public int pop() {
        int res = arr[size - 1];
        size--;
        resize();
        return res;
    }

    public void delete(int index) {
        if(index >= 0 && index < size) {
            for (int i = index + 1; i < size; i++) {
                arr[i - 1] = i;
            }
            size--;
            resize();
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public void remove(int item) {
        for (int i = 0; i < size; i++) {
            if(arr[i] == item) delete(i);
        }
    }

    public int find(int item) {
        for (int i = 0; i < size; i++) {
            if(arr[i] == item) return i;
        }
        return -1;
    }

    private void resize() {
        if(arr.length == size) {
            resize0(arr.length * 2);
        } else if(arr.length > 16 && size == arr.length / 4) {
            resize0(arr.length / 2);
        }
    }

    private void resize0(int newCapacity) {
        int[] newArr = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}