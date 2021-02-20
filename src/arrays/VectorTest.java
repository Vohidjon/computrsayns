package arrays;

public class VectorTest {
    public static void main(String[] args) {
        // testing space allocation logic
        Vector v1 = new Vector();
        Vector v2 = new Vector(10);
        Vector v3 = new Vector(19);
        Vector v4 = new Vector(67);
        Vector v5 = new Vector(64);

        assert v1.capacity() == 16 : "The capacity must be 16";
        assert v2.capacity() == 16 : "The capacity must be 16";
        assert v3.capacity() == 32 : "The capacity must be 32";
        assert v4.capacity() == 128 : "The capacity must be 128";
        assert v5.capacity() == 64 : "The capacity must be 64";

        v1.push(13);
        assert v1.size() == 1 : "Size must be 1";
        v1.push(15);
        assert v1.size() == 2 && v1.at(1) == 15 : "Size must be one and second item should be equal to 15";
        v1.insert(1, 14);
        assert v1.size() == 3 && v1.at(0) == 13 && v1.at(1) == 14 && v1.at(2) == 15: "The second item must be 14 and size must be 3 now";

        v2.prepend(16);
        v2.prepend(12);// 12
        assert v2.at(0) == 12 && v2.size() == 2 : "The first item must be equal to 12 and size must be 2";
        v2.pop();
        assert v2.at(0) != 16 && v2.size() == 1 : "The first item must not be 16 and the size must be 1";

        v3.push(7);
        v3.push(90);
        assert v3.find(90) == 1 : "The item must be at index 1";
        v3.delete(0);
        assert v3.at(0) != 7 : "The index should no longer hold the item 7";

        v4.push(14);
        v4.push(74);
        v4.remove(74);
        assert v4.find(74) == -1 : "The value should no longer be in the vector";
    }
}
