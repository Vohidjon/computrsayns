package arrays;

/**
 * Advantages:
 * - finding the nth item of array takes constant time
 * Disadvantages:
 * - inserting item at beginning or middle takes time proportional to length of array
 * - have fixed length array internally and resizing is costly
 */
public class Vector {
    private int size = 0;
    private int[] arr;

    public Vector() {
        this.arr = new int[16];
    }

    public Vector(int capacity) {
        int n = 4;
        int size = 16;
        while (size < capacity) size = (int) Math.pow(2, ++n);
        this.arr = new int[size];
    }

    public int capacity() {
        return this.arr.length;
    }


    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int at(int index) {
        if (index < this.size) {
            return this.arr[index];
        }
        throw new IndexOutOfBoundsException();
    }

    public void push(int item) {
        this.resize();
        this.size++;
        this.arr[this.size - 1] = item;
    }

    public void insert(int index, int item) {
        this.resize();
        if (index < 0 || index > this.size) throw new IndexOutOfBoundsException();
        for (int i = this.size; i < index; i++) {
            this.arr[i + 1] = this.arr[i];
        }
        this.arr[index] = item;
        this.size++;
    }

    public void prepend(int item) {
        this.resize();
        for (int i = this.size - 1; i >= 0; i--) {
            this.arr[i + 1] = this.arr[i];
        }
        this.arr[0] = item;
        this.size++;
    }

    public int pop() {
        if (!this.isEmpty()) {
            int lastItem = this.arr[this.size - 1];
            this.arr[this.size - 1] = 0; // not so important
            this.size--;
            this.resize();
            return lastItem;
        }
        throw new IndexOutOfBoundsException();
    }

    public int delete(int index) {
        if (index < 0 || index > this.size - 1) throw new IndexOutOfBoundsException();
        int item = this.arr[index];
        for (int i = index; i < this.size - 1; i++) {
            this.arr[index] = this.arr[index + 1];
        }
        this.size--;
        this.resize();
        return item;
    }

    public void remove(int item) {
        int index = this.find(item);
        if (index > -1) {
            this.delete(index);
        }
    }

    public int find(int item) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == item) {
                return i;
            }
        }
        return -1;
    }

    private void resize() {
        if (this.arr.length == this.size) {
            int[] newArr = new int[this.arr.length * 2];
            for (int i = 0; i < this.arr.length; i++) {
                newArr[i] = this.arr[i];
            }
            this.arr = newArr;
        } else if (this.size <= this.capacity() / 4) {
            int[] newArr = new int[this.arr.length / 2];
            for (int i = 0; i < this.size; i++) {
                newArr[i] = this.arr[i];
            }
        }
    }
}
