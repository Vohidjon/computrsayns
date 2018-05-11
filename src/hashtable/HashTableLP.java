package hashtable;

/**
 * Implementation of a hash table with Linear Probing
 * Disadvantages: Possible clustering of items within the array
 * Note: Clustering is the opposite of load balancing
 */
public class HashTableLP {
    private HashTableItem[] array = new HashTableItem[8];

    /**
     * Hashing algorithm: Convert key into a string representation and sum the ASCII codes of each character
     *
     * @param k key
     * @param m probing number
     * @return slot index where the value should go
     */
    private int hash(Object k, int m) {
        String keyStr = k.toString();
        int sum = 0;
        for (char ch : keyStr.toCharArray()) {
            sum += ch;
        }
        System.out.println("Sum: " + sum);
        return (sum + m) % array.length;
    }

    public void add(Object key, Object value) {
        int probeNumber = 0;
        System.out.println("Probing for key " + key);
        while (true){
            int index = this.hash(key, probeNumber);
            System.out.println("Probe " + probeNumber + ": " + index);
            if(this.array[index] == null || this.array[index].deleted) {
                this.array[index] = new HashTableItem(key, value);
                break;
            }
            probeNumber++;
        }
    }

    public boolean exists(Object key) {
        for (int probeNumber = 0; probeNumber < array.length; probeNumber++) {
            int index = this.hash(key, probeNumber);
            HashTableItem itemAtIndex = this.array[index];
            if(itemAtIndex == null) {
                return false;
            } else if (!itemAtIndex.deleted && itemAtIndex.key == key) {
                return true;
            }
        }
        return false;
    }

    public Object get(Object key) {
        for (int probeNumber = 0; probeNumber < array.length; probeNumber++) {
            int index = this.hash(key, probeNumber);
            HashTableItem itemAtIndex = this.array[index];
            if(itemAtIndex == null) {
                return null;
            } else if (!itemAtIndex.deleted && itemAtIndex.key == key) {
                return itemAtIndex.value;
            }
        }
        return null;
    }

    public Object remove(Object key) {
        for (int probeNumber = 0; probeNumber < array.length; probeNumber++) {
            int index = this.hash(key, probeNumber);
            HashTableItem itemAtIndex = this.array[index];
            if(itemAtIndex == null) {
                return null;
            } else if (!itemAtIndex.deleted && itemAtIndex.key == key) {
                itemAtIndex.deleted = true;
                return itemAtIndex.value;
            }
        }
        return null;
    }
}

class HashTableItem {
    public Object key;
    public Object value;
    public boolean deleted = false;
    HashTableItem(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}