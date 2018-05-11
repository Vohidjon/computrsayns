package hashtable;

public class Test {
    public static void main(String[] args) {
        HashTableLP map = new HashTableLP();
        map.add("one", 1);
        map.add("two", 2);
        map.add("three", 3);
        map.add("four", 4);
        map.add("five", 5);
        map.add("six", 6);
        map.add("seven", 7);
        map.add("eight", 8);
        assert map.exists("one") : "Key must exist.";
        assert (int) map.remove("two") == 2 : "Removed value should be equal to 2";
        assert !map.exists("two") : "Should not exist anymore";
        System.out.println(map.get("two"));
    }
}
